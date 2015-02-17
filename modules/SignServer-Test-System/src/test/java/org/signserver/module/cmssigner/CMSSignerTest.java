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
package org.signserver.module.cmssigner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.x509.AttributeCertificateHolder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.signserver.common.GenericSignRequest;
import org.signserver.common.GenericSignResponse;
import org.signserver.common.RequestContext;
import org.signserver.common.SignServerUtil;
import org.signserver.common.WorkerConfig;
import org.signserver.ejb.interfaces.IWorkerSession;
import org.signserver.testutils.ModulesTestCase;
import org.signserver.testutils.TestingSecurityManager;

/**
 * Tests for CMSSigner.
 *
 * @author Markus Kilås
 * @version $Id$
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CMSSignerTest extends ModulesTestCase {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(CMSSignerTest.class);
    
    private static final int WORKERID_ECDSA = 8000;
    private static final int WORKERID_DSA = 8001;
    
    private final IWorkerSession workerSession = getWorkerSession();
    
    @Before
    protected void setUp() throws Exception {
        SignServerUtil.installBCProvider();
    }

    @After
    protected void tearDown() throws Exception {
        TestingSecurityManager.remove();
    }	

    @Test
    public void test00SetupDatabase() throws Exception {
        addSigner("org.signserver.module.cmssigner.CMSSigner");
    }

    /**
     * Tests that the signer can produce a CMS structure and that it returns
     * the signer's certficate and that it is included in the structure and
     * that it can be used to verify the signature and that the signed content
     * also is included. Also test that the default signature algorithm is SHA1withRSA
     * @throws Exception In case of error.
     */
    @Test
    public void test01BasicCMSSignRSA() throws Exception {
        LOG.debug(">test01BasicCMSSignRSA");

        helperBasicCMSSign(getSignerIdDummy1(), null, "1.3.14.3.2.26", "1.2.840.113549.1.1.1", null, 1);
        
        LOG.debug("<test01BasicCMSSignRSA");
    }
    
    /**
     * Test setting SIGNATUREALGORITHM to a non-default value.
     * @throws Exception
     */
    @Test
    public void test02BasicCMSSignSHA256withRSA() throws Exception {
        helperBasicCMSSign(getSignerIdDummy1(), "SHA256withRSA", "2.16.840.1.101.3.4.2.1", "1.2.840.113549.1.1.1",
                null, 1);
    }
    
    /**
     * Test with ECDSA encryption algorithm.
     * 
     * @throws Exception
     */
    @Test
    public void test03BasicCMSSignSHA1withECDSA() throws Exception {
        // Setup signer
        final File keystore = new File(getSignServerHome(), "res/test/dss10/dss10_signer5ec.p12");
        if (!keystore.exists()) {
            throw new FileNotFoundException(keystore.getAbsolutePath());
        }
        addP12DummySigner("org.signserver.module.cmssigner.CMSSigner", WORKERID_ECDSA, "TestCMSSignerP12ECDSA", keystore, "foo123", null);
        workerSession.reloadConfiguration(WORKERID_ECDSA);
        
        helperBasicCMSSign(WORKERID_ECDSA, "SHA1withECDSA", "1.3.14.3.2.26", "1.2.840.10045.4.1", null, 1);
        
        removeWorker(WORKERID_ECDSA);
    }

    /**
     * Test with DSA encryption algorithm.
     * 
     * @throws Exception
     */
    @Test
    public void test04BasicCMSSignSHA1withDSA() throws Exception {
        // Setup signer
        final File keystore = new File(getSignServerHome(), "res/test/dss10/dss10_tssigner6dsa.jks");
        if (!keystore.exists()) {
            throw new FileNotFoundException(keystore.getAbsolutePath());
        }
        addJKSDummySigner("org.signserver.module.cmssigner.CMSSigner", WORKERID_DSA, "TestCMSSignerJKSDSA", keystore, "foo123", "mykey");
        workerSession.reloadConfiguration(WORKERID_DSA);
        
        helperBasicCMSSign(WORKERID_DSA, "SHA1withDSA", "1.3.14.3.2.26", "1.2.840.10040.4.3", null, 1);
        
        removeWorker(WORKERID_DSA);
    }
    
    /**
     * Test with no included certificates.
     * 
     * @throws Exception
     */
    @Test
    public void test05IncludeNoCerts() throws Exception {
        helperBasicCMSSign(getSignerIdDummy1(), null, "1.3.14.3.2.26", "1.2.840.113549.1.1.1", "0", 0);
    }
    
    /**
     * Test explicitly specifying 1 certificate to be included.
     * 
     * @throws Exception
     */
    @Test
    public void test06ExplicitIncludedCerts() throws Exception {
        helperBasicCMSSign(getSignerIdDummy1(), null, "1.3.14.3.2.26", "1.2.840.113549.1.1.1", "1", 1);
    }
    
    /**
     * Test specifying more certificates than are available.
     * 
     * @throws Exception
     */
    @Test
    public void test07TruncatedIncludedCerts() throws Exception {
        helperBasicCMSSign(getSignerIdDummy1(), null, "1.3.14.3.2.26", "1.2.840.113549.1.1.1", "2", 1);
    }

    private void helperBasicCMSSign(final int workerId, final String sigAlg, final String expectedDigAlgOID,
            final String expectedEncAlgOID, final String includedCertificateLevelsProperty,
            final int expectedIncludedCertificateLevels) throws Exception {
        final int reqid = 37;

        final String testDocument = "Something to sign...123";

        final GenericSignRequest signRequest =
                new GenericSignRequest(reqid, testDocument.getBytes());

        // override signature algorithm if set
        if (sigAlg != null) {
            workerSession.setWorkerProperty(workerId, CMSSigner.SIGNATUREALGORITHM_PROPERTY, sigAlg);
        } else {
            workerSession.removeWorkerProperty(workerId, CMSSigner.SIGNATUREALGORITHM_PROPERTY);
        }
        
        if (includedCertificateLevelsProperty != null) {
            workerSession.setWorkerProperty(workerId,
                    WorkerConfig.PROPERTY_INCLUDE_CERTIFICATE_LEVELS,
                    includedCertificateLevelsProperty);
        } else {
            workerSession.removeWorkerProperty(workerId, WorkerConfig.PROPERTY_INCLUDE_CERTIFICATE_LEVELS);
        }
        
        workerSession.reloadConfiguration(workerId);
        
        final GenericSignResponse res =
                (GenericSignResponse) workerSession.process(workerId, signRequest, new RequestContext());
        final byte[] data = res.getProcessedData();
   
        // Answer to right question
        assertSame("Request ID", reqid, res.getRequestID());

        // Output for manual inspection
        final FileOutputStream fos = new FileOutputStream(
                new File(getSignServerHome(),
                "tmp" + File.separator + "signedcms_" + sigAlg + ".p7s"));
        fos.write((byte[]) data);
        fos.close();

        // Check certificate returned
        final Certificate signercert = res.getSignerCertificate();
        assertNotNull("Signer certificate", signercert);

        // Check that the signed data contains the document (i.e. not detached)
        final CMSSignedData signedData = new CMSSignedData(data);
        final byte[] content = (byte[]) signedData.getSignedContent()
                .getContent();
        assertEquals("Signed document", testDocument, new String(content));

        // Get signers
        final Collection signers = signedData.getSignerInfos().getSigners();
        final SignerInformation signer
                = (SignerInformation) signers.iterator().next();

        // Verify using the signer's certificate
        assertTrue("Verification using signer certificate",
                signer.verify(signercert.getPublicKey(), "BC"));

        // Check that the signer's certificate is included
        CertStore certs = signedData.getCertificatesAndCRLs("Collection", "BC");
        X509Principal issuer = new X509Principal(signer.getSID().getIssuer());
        CertSelector cs = new AttributeCertificateHolder(issuer, signer.getSID().getSerialNumber());
        Collection<? extends Certificate> signerCerts
                = certs.getCertificates(cs);
        assertEquals("Certificate included", expectedIncludedCertificateLevels, signerCerts.size());
        if (!signerCerts.isEmpty()) {
            assertEquals(signercert, signerCerts.iterator().next());
        }

        // check the signature algorithm
        assertEquals("Digest algorithm", expectedDigAlgOID, signer.getDigestAlgorithmID().getAlgorithm().getId());
        assertEquals("Encryption algorithm", expectedEncAlgOID, signer.getEncryptionAlgOID());   
    }

    /**
     * Remove the workers created etc.
     * @throws Exception in case of error
     */
    @Test
    public void test99TearDownDatabase() throws Exception {
        removeWorker(getSignerIdDummy1());
    }
}
