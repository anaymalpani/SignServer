/*************************************************************************
 *                                                                       *
 *  SignServer: The OpenSource Automated Signing Server                  *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.signserver.server.cryptotokens;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.Properties;
import javax.ejb.EJB;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.ECKeyUtil;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.ejbca.util.Base64;
import org.ejbca.util.CertTools;
import org.ejbca.util.keystore.KeyTools;
import org.signserver.common.Base64SignerCertReqData;
import org.signserver.common.CryptoTokenAuthenticationFailureException;
import org.signserver.common.CryptoTokenOfflineException;
import org.signserver.common.ICertReqData;
import org.signserver.common.ISignerCertReqInfo;
import org.signserver.common.PKCS10CertReqInfo;
import org.signserver.common.SignerStatus;
import org.signserver.ejb.interfaces.IWorkerSession;
import org.signserver.common.KeyTestResult;
import org.signserver.common.ServiceLocator;

/**
 * Cryptographic token that uses soft keys stored in the worker properties in the database.
 * Is support generation of certificate requests and regeneration of keys.
 * Every time genCertificateRequest is called i a new key called. destroyKey method
 * is not supported.
 * 
 * 
 * Currently is only one key supported used for all purposes.
 * 
 * This Cryptographic token should mainly be used for test and demonstration purposes
 * not for production.
 * 
 * Available properties are:
 * KEYALG : The algorithms of the keys generated. (for future use, currently is only "RSA" supported and the one used by default).
 * KEYSPEC : The specification of the keys generated. (Optional). If not set will "2048" be used.
 * KEYDATA : The base64 encoded key data.
 * 
 * @author Philip Vendil
 * $Id$
 */
public class SoftCryptoToken implements ICryptoToken {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(SoftCryptoToken.class);
	
    public static final String PROPERTY_KEYDATA = "KEYDATA";
    public static final String PROPERTY_KEYALG = "KEYALG";
    public static final String PROPERTY_KEYSPEC = "KEYSPEC";
	
    private int workerId;
    private KeyPair keys = null;
    private String keySpec = null;
    private String keyAlg = null;
    private boolean active = true;
    
    @EJB // FIXME: Won't work, always uses lookup. Consider doing manual injection using the init method or similar. If it really needs to use the worker session?
    private IWorkerSession.IRemote workerSession;

    /**
     * @see org.signserver.server.cryptotokens.ICryptoToken#init(int, java.util.Properties)
     */
    public void init(int workerId, Properties props) {
        this.workerId = workerId;
        keySpec = props.getProperty(PROPERTY_KEYSPEC, "2048");
        keyAlg = props.getProperty(PROPERTY_KEYALG, "RSA");

        if (props.getProperty(PROPERTY_KEYDATA) != null) {
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");

                byte[] keyData = Base64.decode(props.getProperty(PROPERTY_KEYDATA).getBytes());
                ByteArrayInputStream bais = new ByteArrayInputStream(keyData);
                DataInputStream dis = new DataInputStream(bais);

                int pubKeySize = dis.readInt();
                byte[] pubKeyData = new byte[pubKeySize];
                dis.read(pubKeyData, 0, pubKeySize);
                int privKeySize = dis.readInt();
                byte[] privKeyData = new byte[privKeySize];
                dis.read(privKeyData, 0, privKeySize);
                // decode public key
                X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyData);
                RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);

                // decode private key
                PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyData);
                RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);

                keys = new KeyPair(pubKey, privKey);
            } catch (NoSuchAlgorithmException e) {
                LOG.error("Error loading soft keys : ", e);
            } catch (IOException e) {
                LOG.error("Error loading soft keys : ", e);
            } catch (InvalidKeySpecException e) {
                LOG.error("Error loading soft keys : ", e);
            }
        } else {
            active = false;
        }

    }

    /**
     * Returns true if the key store was properly loaded
     * 
     * @see org.signserver.server.cryptotokens.ICryptoToken#getCryptoTokenStatus()
     * 
     */
    public int getCryptoTokenStatus() {
        if (active) {
            return SignerStatus.STATUS_ACTIVE;
        }
        return SignerStatus.STATUS_OFFLINE;
    }

    /**
     * Loads the key store into memory
     * 
     * @see org.signserver.server.cryptotokens.ICryptoToken#activate(java.lang.String)
     */
    public void activate(String authenticationcode)
            throws CryptoTokenAuthenticationFailureException,
            CryptoTokenOfflineException {
        active = true;
    }

    /**
     * Method that clear the key data from memory.
     * 
     * @see org.signserver.server.cryptotokens.ICryptoToken#deactivate()
     */
    public boolean deactivate() {
        active = false;
        return true;
    }

    /**
     * Returns the same private key for all purposes.
     * @see org.signserver.server.cryptotokens.ICryptoToken#getPrivateKey(int)
     */
    public PrivateKey getPrivateKey(int purpose)
            throws CryptoTokenOfflineException {

        if (!active) {
            throw new CryptoTokenOfflineException("Signtoken isn't active.");
        }
        return keys.getPrivate();
    }

    /**
     * Returns the same public key for all purposes.
     * @see org.signserver.server.cryptotokens.ICryptoToken#getPublicKey(int)
     */
    public PublicKey getPublicKey(int purpose) throws CryptoTokenOfflineException {

        if (!active) {
            throw new CryptoTokenOfflineException("Signtoken isn't active.");
        }
        return keys.getPublic();
    }

    /**
     * Always returns BC.
     * @see org.signserver.server.cryptotokens.ICryptoToken#getPrivateKey(int)
     */
    @Override
    public String getProvider(int providerUsage) {
        return "BC";
    }

    public Certificate getCertificate(int purpose) throws CryptoTokenOfflineException {
        return null;
    }

    public Collection<Certificate> getCertificateChain(int purpose) throws CryptoTokenOfflineException {
        return null;
    }

    /**
     * Special method that generates a new key pair that is written to the worker configuration
     * before the request is generated. The new keys aren't activated until reload is issued.
     * 
     */
    @Override
    public ICertReqData genCertificateRequest(ISignerCertReqInfo info,
            final boolean explicitEccParameters, final boolean defaultKey)
            throws CryptoTokenOfflineException {
        Base64SignerCertReqData retval = null;

        try {
            KeyPair newKeys = KeyTools.genKeys(keySpec, keyAlg);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            byte[] pubKeyData = newKeys.getPublic().getEncoded();
            byte[] prvKeyData = newKeys.getPrivate().getEncoded();
            dos.writeInt(pubKeyData.length);
            dos.write(pubKeyData);
            dos.writeInt(prvKeyData.length);
            dos.write(prvKeyData);

            getWorkerSession().setWorkerProperty(workerId, PROPERTY_KEYDATA, new String(Base64.encode(baos.toByteArray())));

            if (info instanceof PKCS10CertReqInfo) {
                PKCS10CertReqInfo reqInfo = (PKCS10CertReqInfo) info;
                PKCS10CertificationRequest pkcs10;
                PublicKey publicKey = newKeys.getPublic();

                // Handle ECDSA key with explicit parameters
                if (explicitEccParameters
                        && publicKey.getAlgorithm().contains("EC")) {
                    publicKey = ECKeyUtil.publicToExplicitParameters(publicKey,
                            "BC");
                }
                // Generate request
                pkcs10 = new PKCS10CertificationRequest(reqInfo.getSignatureAlgorithm(), CertTools.stringToBcX509Name(reqInfo.getSubjectDN()), publicKey, reqInfo.getAttributes(), newKeys.getPrivate(), getProvider(ICryptoToken.PROVIDERUSAGE_SIGN));
                retval = new Base64SignerCertReqData(Base64.encode(pkcs10.getEncoded()));
            }
        } catch (NoSuchAlgorithmException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (NoSuchProviderException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (InvalidAlgorithmParameterException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (InvalidKeyException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (SignatureException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (IOException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        } catch (NamingException e1) {
            LOG.error("Error generating new certificate request : " + e1.getMessage(), e1);
        }
        return retval;
    }

    /**
     * Method not supported
     */
    public boolean destroyKey(int purpose) {
        LOG.error("destroyKey method isn't supported");
        return false;
    }

    protected IWorkerSession.IRemote getWorkerSession() throws NamingException {
        if (workerSession == null) {
            workerSession = ServiceLocator.getInstance().lookupRemote(
                    IWorkerSession.IRemote.class);
        }
        return workerSession;
    }

    public Collection<KeyTestResult> testKey(final String alias,
            final char[] authCode) throws CryptoTokenOfflineException,
            KeyStoreException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KeyStore getKeyStore() throws UnsupportedOperationException,
            CryptoTokenOfflineException, KeyStoreException {
        throw new UnsupportedOperationException(
                "Operation not supported by crypto token.");
    }
}
