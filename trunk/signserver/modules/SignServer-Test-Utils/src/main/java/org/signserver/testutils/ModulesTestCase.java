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
package org.signserver.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.*;
import javax.naming.NamingException;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.ejbca.util.Base64;
import org.signserver.admin.cli.AdminCLI;
import org.signserver.client.cli.ClientCLI;
import org.signserver.common.CryptoTokenOfflineException;
import org.signserver.common.GenericSignRequest;
import org.signserver.common.GenericSignResponse;
import org.signserver.common.GlobalConfiguration;
import org.signserver.common.IllegalRequestException;
import org.signserver.common.InvalidWorkerIdException;
import org.signserver.common.RequestContext;
import org.signserver.common.ServiceLocator;
import org.signserver.common.SignServerException;
import org.signserver.common.WorkerConfig;
import org.signserver.common.util.PathUtil;
import org.signserver.ejb.interfaces.IGlobalConfigurationSession;
import org.signserver.ejb.interfaces.IWorkerSession;
import org.signserver.statusrepo.IStatusRepositorySession;

/**
 * Base class for test cases.
 *
 * @author Markus Kilås
 * @version $Id$
 */
public class ModulesTestCase extends TestCase {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(ModulesTestCase.class);

    private static final int DUMMY1_SIGNER_ID = 5676;
    private static final String DUMMY1_SIGNER_NAME = "TestXMLSigner";
    
    private static final int CMSSIGNER1_ID = 5677;
    private static final String CMSSIGNER1_NAME = "TestCMSSigner";
    
    private static final int PDFSIGNER1_ID = 5678;
    private static final String PDFSIGNER1_NAME = "TestPDFSigner";
    
    private static final int TIMESTAMPSIGNER1_SIGNER_ID = 5879;
    private static final String TIMESTAMPSIGNER1_SIGNER_NAME = "TestTimeStampSigner";
    
    private static final int SODSIGNER1_SIGNER_ID = 5880;
    private static final String SODSIGNER1_SIGNER_NAME = "TestSODSigner";
    
    private static final int VALIDATION_SERVICE_WORKER_ID = 5881;
    private static final String VALIDATION_SERVICE_WORKER_NAME = "TestValidationWorker";
    
    private static final int XML_VALIDATOR_WORKER_ID = 5882;
    private static final String XML_VALIDATOR_WORKER_NAME = "TestXMLValidator";

    private static final String KEYSTORE_SIGNER1_FILE = "res/test/dss10/dss10_signer1.p12";
    private static final String KEYSTORE_SIGNER1_ALIAS = "Signer 1";
    private static final String KEYSTORE_TSSIGNER1_FILE = "res/test/dss10/dss10_tssigner1.p12";
    private static final String KEYSTORE_TSSIGNER1_ALIAS = "TS Signer 1";
    public static final String KEYSTORE_PASSWORD = "foo123";

    /**
     * SerialNumber: 32:4d:41:38:af:02:c1:3c
     * IssuerDN: CN=DSS Root CA 10, OU=Testing, O=SignServer, C=SE
     * Not Before: May 27 08:14:27 2011 GMT
     * Not After : May 27 08:14:27 2036 GMT
     *  SubjectDN: CN=DSS Root CA 10, OU=Testing, O=SignServer, C=SE
     */
   private static final String VALIDATOR_CERT_ISSUER =
        "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"
       + "dMwk/ZXzsDjMZEtENaBXzAefYA==";

   /**
    * Certificate for DemoRootCA2.
    *
    * <pre>
    * Serial Number: 26:02:00:71:07:af:7f:95
    *   Signature Algorithm: dsaWithSHA1
    *   Issuer: CN=DemoRootCA2, OU=EJBCA, O=SignServer Sample, C=SE
    *   Validity
    *       Not Before: Nov  9 16:09:48 2009 GMT
    *       Not After : Nov 10 16:09:48 2034 GMT
    *   Subject: CN=DemoRootCA2, OU=EJBCA, O=SignServer Sample, C=SE
    * </pre>
    */
   private static final String VALIDATOR_CERT_ISSUER4 =
       "MIIDPTCCAvygAwIBAgIIJgIAcQevf5UwCQYHKoZIzjgEAzBPMRQwEgYDVQQDDAtE"
       +"ZW1vUm9vdENBMjEOMAwGA1UECwwFRUpCQ0ExGjAYBgNVBAoMEVNpZ25TZXJ2ZXIg"
       +"U2FtcGxlMQswCQYDVQQGEwJTRTAeFw0wOTExMDkxNjA5NDhaFw0zNDExMTAxNjA5"
       +"NDhaME8xFDASBgNVBAMMC0RlbW9Sb290Q0EyMQ4wDAYDVQQLDAVFSkJDQTEaMBgG"
       +"A1UECgwRU2lnblNlcnZlciBTYW1wbGUxCzAJBgNVBAYTAlNFMIIBtzCCASsGByqG"
       +"SM44BAEwggEeAoGBAI+d9uiMBBzqdvlV3wSMdwRv/Qx2POGqh+m0M0tMYEwIGBdZ"
       +"Hm3+QSKIDTjcLRJgCGgTXSAJPCZtp43+kWCV5iGbbemBchOCh4Oe/4IPQERlfJhy"
       +"MH0gXLglG9KSbuKkqMSzaZoZk06q750KBKusKhK+mvhp08++KyXZna3p6itdAhUA"
       +"ntjYRJsYqqQtIt0htCGCEAHCkg8CgYA4E4VMplm16uizoUL+9erNtLI886f8pdO5"
       +"vXhcQG9IpZ0J7N6M4WQy8CFzTKjRJLs27TO2gDP8BE50mMOnbRvYmGIJsQ9lZHTj"
       +"UqltWh9PJ0VKF0fCwQbA3aY+v8PiHxELvami+YyBiYjE2C6b1ArKOw1QsEL0KakJ"
       +"cr22yWFaKgOBhQACgYEAiTsSMcEKhYCWg2ULDwD/4ueYyDcRvyoSrT7uCdGU0Y/w"
       +"2wPuI+kV5RfHxjs6YLDuJsQJg6rfi3RfgmwQJVzClDfgUN12qzRbSidepg/7ipkC"
       +"Gk0/eyY1A99z3K+FUZm2MVgune4ywCorPUpxz6WHS7/dSWYMWtSrr92PzgnwZbKj"
       +"YzBhMB0GA1UdDgQWBBRJ3xUuyl6ZroD3lFm3nw/AhCPeJTAPBgNVHRMBAf8EBTAD"
       +"AQH/MB8GA1UdIwQYMBaAFEnfFS7KXpmugPeUWbefD8CEI94lMA4GA1UdDwEB/wQE"
       +"AwIBhjAJBgcqhkjOOAQDAzAAMC0CFQCEGSmvJf6rxy6u7ZqY25qE7Hy21gIUPW4q"
       +"++YIS2fHyu+H4Pjgnodx5zI=";
   
    private IWorkerSession.IRemote workerSession;
    private IGlobalConfigurationSession globalSession;
    private IStatusRepositorySession statusSession;

    private static File signServerHome;

    private Properties config;
    
    private CLITestHelper adminCLI;
    private CLITestHelper clientCLI;
    private TestUtils testUtils = new TestUtils();
    protected static Random random = new Random(1234);

    public ModulesTestCase() {
        final Properties defaultConfig = new Properties();
        InputStream in = null;
        try {
            defaultConfig.load(getClass().getResourceAsStream("/org/signserver/testutils/default-test-config.properties"));
            config = new Properties(defaultConfig);
            final File configFile = new File(getSignServerHome(),
                    "test-config.properties");
            if (configFile.exists()) {
                in = new FileInputStream(configFile);
                config.load(in);
                setupSSLKeystores();
            }
        } catch (Exception ex) {
            fail("Could not load test configuration: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    LOG.error("Could not close config file", ex);
                }
            }
        }
    }

    public CLITestHelper getAdminCLI() {
        if (adminCLI == null) {
            adminCLI = new CLITestHelper(AdminCLI.class);
        }
        return adminCLI;
    }

    public CLITestHelper getClientCLI() {
        if (clientCLI == null) {
            clientCLI = new CLITestHelper(ClientCLI.class);
        }
        return clientCLI;
    }
    
    

    protected IWorkerSession.IRemote getWorkerSession() {
        if (workerSession == null) {
            try {
                workerSession = ServiceLocator.getInstance().lookupRemote(
                    IWorkerSession.IRemote.class);
            } catch (NamingException ex) {
                fail("Could not lookup IWorkerSession: " + ex.getMessage());
            }
        }
        return workerSession;
    }

    protected IGlobalConfigurationSession getGlobalSession() {
        if (globalSession == null) {
            try {
                globalSession = ServiceLocator.getInstance().lookupRemote(
                    IGlobalConfigurationSession.IRemote.class);
            } catch (NamingException ex) {
                fail("Could not lookup IGlobalConfigurationSession: "
                        + ex.getMessage());
            }
        }
        return globalSession;
    }

    protected IStatusRepositorySession getStatusSession() {
        if (statusSession == null) {
            try {
                statusSession = ServiceLocator.getInstance().lookupRemote(
                IStatusRepositorySession.IRemote.class);
            } catch (NamingException ex) {
                fail("Could not lookup IStatusRepositorySession: "
                        + ex.getMessage());
            }
        }
        return statusSession;
    }

    protected void addDummySigner1() throws CertificateException, FileNotFoundException {
        addP12DummySigner(getSignerIdDummy1(), getSignerNameDummy1(), new File(getSignServerHome(), KEYSTORE_SIGNER1_FILE), KEYSTORE_PASSWORD, KEYSTORE_SIGNER1_ALIAS);
    }

    protected int getSignerIdDummy1() {
        return DUMMY1_SIGNER_ID;
    }

    protected String getSignerNameDummy1() {
        return DUMMY1_SIGNER_NAME;
    }
    
    protected int getSignerIdTimeStampSigner1() {
        return TIMESTAMPSIGNER1_SIGNER_ID;
    }

    protected String getSignerNameTimeStampSigner1() {
        return TIMESTAMPSIGNER1_SIGNER_NAME;
    }
    
    protected int getSignerIdSODSigner1() {
        return SODSIGNER1_SIGNER_ID;
    }

    protected String getSignerNameSODSigner1() {
        return SODSIGNER1_SIGNER_NAME;
    }
    
    protected void addCMSSigner1() throws CertificateException, FileNotFoundException {
        addP12DummySigner("org.signserver.module.cmssigner.CMSSigner",
                getSignerIdCMSSigner1(), getSignerNameCMSSigner1(), new File(getSignServerHome(), KEYSTORE_SIGNER1_FILE), KEYSTORE_PASSWORD, KEYSTORE_SIGNER1_ALIAS);
    }
    
    protected void addPDFSigner1() throws CertificateException, FileNotFoundException {
    	addP12DummySigner("org.signserver.module.pdfsigner.PDFSigner",
                getSignerIdPDFSigner1(), getSignerNamePDFSigner1(), new File(getSignServerHome(), KEYSTORE_SIGNER1_FILE), KEYSTORE_PASSWORD, KEYSTORE_SIGNER1_ALIAS);
    }
    
    protected int getSignerIdCMSSigner1() {
        return CMSSIGNER1_ID;
    }
    
    protected String getSignerNameCMSSigner1() {
        return CMSSIGNER1_NAME;
    }
    
    protected int getSignerIdPDFSigner1() {
    	return PDFSIGNER1_ID;
    }
    
    protected String getSignerNamePDFSigner1() {
    	return PDFSIGNER1_NAME;
    }

    protected void addSigner(final String className) 
            throws CertificateException, FileNotFoundException {
        addSigner(className, DUMMY1_SIGNER_ID, DUMMY1_SIGNER_NAME);
    }
    
    protected void addDummySigner(final int signerId, final String signerName) throws CertificateException, FileNotFoundException {
        addSigner("org.signserver.module.xmlsigner.XMLSigner", signerId, signerName);
    }
    
    protected void addSigner(final String className,
            final int signerId, final String signerName)
        throws CertificateException, FileNotFoundException {
        addP12DummySigner(className, signerId, signerName,
                new File(getSignServerHome(), KEYSTORE_SIGNER1_FILE), null, KEYSTORE_SIGNER1_ALIAS);
    }

    /**
     * Load worker/global properties from file. This is not a complete 
     * implementation as the one used by the "setproperties" CLI command but 
     * enough to load the junittest-part-config.properties files used by the 
     * tests.
     * @param file The properties file to load
     * @throws IOException
     * @throws CertificateException in case a certificate could not be decoded 
     */
    protected void setProperties(final File file) throws IOException, CertificateException {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(in);
            setProperties(properties);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
    
    /**
     * Load worker/global properties from file. This is not a complete 
     * implementation as the one used by the "setproperties" CLI command but 
     * enough to load the junittest-part-config.properties files used by the 
     * tests.
     * @param in The inputstream to read properties from
     * @throws IOException
     * @throws CertificateException in case a certificate could not be decoded 
     */
    protected void setProperties(final InputStream in) throws IOException, CertificateException {
        try {
            Properties properties = new Properties();
            properties.load(in);
            setProperties(properties);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
    
    /**
     * Load worker/global properties. This is not a complete 
     * implementation as the one used by the "setproperties" CLI command but 
     * enough to load the junittest-part-config.properties files used by the 
     * tests.
     * @param file The properties file to load
     * @throws CertificateException in case a certificate could not be decoded
     */
    protected void setProperties(final Properties properties) throws CertificateException {
        for (Object o : properties.keySet()) {
            if (o instanceof String) {
                String key = (String) o;
                String value = properties.getProperty(key);
                if (key.startsWith("GLOB.")) {
                    key = key.substring("GLOB.".length());
                    getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL, key, value);
                } else if (key.startsWith("WORKER") && key.contains(".") && key.indexOf(".") + 1 < key.length()) {
                    int id = Integer.parseInt(key.substring("WORKER".length(), key.indexOf(".")));
                    key = key.substring(key.indexOf(".") + 1);

                    if (key.startsWith("SIGNERCERTCHAIN")) {
                        String certs[] = value.split(";");
                        ArrayList<byte[]> chain = new ArrayList<byte[]>();
                        for (String base64cert : certs) {
                            byte[] cert = Base64.decode(base64cert.getBytes());
                            chain.add(cert);
                        }
                        getWorkerSession().uploadSignerCertificateChain(id, chain, GlobalConfiguration.SCOPE_GLOBAL);
                    } else {
                        getWorkerSession().setWorkerProperty(id, key, value);
                    }

                } else {
                    throw new RuntimeException("Unknown format for property: " + key);
                }
            }
        }
    }
    
    protected void addP12DummySigner(final int signerId, final String signerName, final File keystore, final String password, final String alias) {
        addP12DummySigner("org.signserver.module.xmlsigner.XMLSigner",
                signerId, signerName, keystore, password, alias);
    }

    protected void addP12DummySigner(final String className, final int signerId, final String signerName, final File keystore, final String password, final String alias) {
        addDummySigner(className, "org.signserver.server.cryptotokens.P12CryptoToken", signerId, signerName, keystore, password, alias);
    }
    
    protected void addJKSDummySigner(final String className, final int signerId, final String signerName, final File keystore, final String password, final String alias) {
        addDummySigner(className, "org.signserver.server.cryptotokens.JKSCryptoToken", signerId, signerName, keystore, password, alias);
    }
    
    protected void addDummySigner(final String className, final String cryptoTokenClassName, final int signerId, final String signerName, final File keystore, final String password, final String alias) {
        getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL,
            "WORKER" + signerId + ".CLASSPATH", className);
        getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL,
            "WORKER" + signerId + ".SIGNERTOKEN.CLASSPATH",
            cryptoTokenClassName);
        getWorkerSession().setWorkerProperty(signerId, "NAME", signerName);
        getWorkerSession().setWorkerProperty(signerId, "AUTHTYPE", "NOAUTH");
        getWorkerSession().setWorkerProperty(signerId, "KEYSTOREPATH", keystore.getAbsolutePath());
        if (alias != null) {
            getWorkerSession().setWorkerProperty(signerId, "DEFAULTKEY", alias);
        }
        if (password != null) {
            getWorkerSession().setWorkerProperty(signerId, "KEYSTOREPASSWORD", password);
        }

        getWorkerSession().reloadConfiguration(signerId);
        try {
            assertNotNull("Check signer available",
                    getWorkerSession().getStatus(signerId));
        } catch (InvalidWorkerIdException ex) {
            fail("Worker was not added succefully: " + ex.getMessage());
        }
    }    
    
    protected void addTimeStampSigner(final int signerId, final String signerName) throws CertificateException, FileNotFoundException {
        addP12DummySigner(signerId, signerName, new File(getSignServerHome(), KEYSTORE_TSSIGNER1_FILE), KEYSTORE_PASSWORD, KEYSTORE_TSSIGNER1_ALIAS);
    }
    
    
    protected void addXMLValidator() throws Exception {
        // VALIDATION SERVICE
        getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL, "WORKER" + VALIDATION_SERVICE_WORKER_ID + ".CLASSPATH", "org.signserver.validationservice.server.ValidationServiceWorker");
        getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL, "WORKER" + VALIDATION_SERVICE_WORKER_ID + ".SIGNERTOKEN.CLASSPATH", "org.signserver.server.cryptotokens.HardCodedCryptoToken");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "AUTHTYPE", "NOAUTH");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "NAME", VALIDATION_SERVICE_WORKER_NAME);
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "VAL1.CLASSPATH", "org.signserver.validationservice.server.DummyValidator");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "VAL1.ISSUER1.CERTCHAIN", "\n-----BEGIN CERTIFICATE-----\n" + VALIDATOR_CERT_ISSUER + "\n-----END CERTIFICATE-----\n");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "VAL1.ISSUER2.CERTCHAIN", "\n-----BEGIN CERTIFICATE-----\n" + VALIDATOR_CERT_ISSUER4 + "\n-----END CERTIFICATE-----\n");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "VAL1.TESTPROP", "TEST");
        getWorkerSession().setWorkerProperty(VALIDATION_SERVICE_WORKER_ID, "VAL1.REVOKED", "");
        getWorkerSession().reloadConfiguration(VALIDATION_SERVICE_WORKER_ID);

        // XMLVALIDATOR
        getGlobalSession().setProperty(GlobalConfiguration.SCOPE_GLOBAL, "WORKER" + XML_VALIDATOR_WORKER_ID + ".CLASSPATH", "org.signserver.module.xmlvalidator.XMLValidator");
        getWorkerSession().setWorkerProperty(XML_VALIDATOR_WORKER_ID, "NAME", XML_VALIDATOR_WORKER_NAME);
        getWorkerSession().setWorkerProperty(XML_VALIDATOR_WORKER_ID, "AUTHTYPE", "NOAUTH");
        getWorkerSession().setWorkerProperty(XML_VALIDATOR_WORKER_ID, "VALIDATIONSERVICEWORKER", VALIDATION_SERVICE_WORKER_NAME);
        getWorkerSession().reloadConfiguration(XML_VALIDATOR_WORKER_ID);
    }
    
    public int getWorkerIdXmlValidator() {
        return XML_VALIDATOR_WORKER_ID;
    }
    
    public String getWorkerNameXmlValidator() {
        return XML_VALIDATOR_WORKER_NAME;
    }
    
    public int getWorkerIdValidationService() {
        return VALIDATION_SERVICE_WORKER_ID;
    }

    private void removeGlobalProperties(int workerid) {
        final GlobalConfiguration gc = getGlobalSession().getGlobalConfiguration();
        final Enumeration<String> en = gc.getKeyEnumeration();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            if (key.toUpperCase(Locale.ENGLISH)
                    .startsWith("GLOB.WORKER" + workerid)) {
                key = key.substring("GLOB.".length());
                getGlobalSession().removeProperty(GlobalConfiguration.SCOPE_GLOBAL, key);
            }
        }
    }

    protected void removeWorker(final int workerId) throws Exception {
        removeGlobalProperties(workerId);
        WorkerConfig wc = getWorkerSession().getCurrentWorkerConfig(workerId);
        LOG.info("Got current config: " + wc.getProperties());
        final Iterator<Object> iter = wc.getProperties().keySet().iterator();
        while (iter.hasNext()) {
            final String key = (String) iter.next();
            getWorkerSession().removeWorkerProperty(workerId, key);
        }
        getWorkerSession().reloadConfiguration(workerId);  
        wc = getWorkerSession().getCurrentWorkerConfig(workerId);
        LOG.info("Got current config after: " + wc.getProperties());
    }

    protected File getSignServerHome() throws FileNotFoundException {
        if (signServerHome == null) {
            signServerHome = PathUtil.getAppHome();
        }
        return signServerHome;
    }

    protected Properties getConfig() {
        return config;
    }

    protected int getPublicHTTPPort() {
        return Integer.parseInt(config.getProperty("httpserver.pubhttp"));
    }

    protected int getPublicHTTPSPort() {
        return Integer.parseInt(config.getProperty("httpserver.pubhttps"));
    }

    protected int getPrivateHTTPSPort() {
        return Integer.parseInt(config.getProperty("httpserver.privhttps"));
    }
    
    protected String getHTTPHost() {
        return config.getProperty("httpserver.hostname", "localhost");
    }
    
    protected String getPreferredHTTPProtocol() {
        return config.getProperty("httpserver.prefproto", "http://");
    }
    
    protected int getPreferredHTTPPort() {
        return Integer.parseInt(config.getProperty("httpserver.prefport", config.getProperty("httpserver.pubhttp")));
    }
    
    /** @return IP used by JUnit tests to access SignServer through the HTTPHost. */
    protected String getClientIP() {
        return config.getProperty("httpclient.ipaddress", "127.0.0.1");
    }

    /** Setup keystores for SSL. **/
    protected void setupSSLKeystores() throws KeyStoreException, IOException, FileNotFoundException, NoSuchAlgorithmException, CertificateException, KeyManagementException, UnrecoverableKeyException {
        testUtils.setupSSLTruststore();
    }
    
    protected TestUtils getTestUtils() {
        return testUtils;
    }

    /**
     * Make a GenericSignRequest.
     */
    protected GenericSignResponse signGenericDocument(final int workerId, final byte[] data) throws IllegalRequestException, CryptoTokenOfflineException, SignServerException {
        final int requestId = random.nextInt();
        final GenericSignRequest request = new GenericSignRequest(requestId, data);
        final GenericSignResponse response = (GenericSignResponse) getWorkerSession().process(workerId, request, new RequestContext());
        assertEquals("requestId", requestId, response.getRequestID());
        Certificate signercert = response.getSignerCertificate();
        assertNotNull(signercert);
        return response;
    }

    /**
     * @return First certificate in semicolon separated list of base64 encoded certificate
     */
    private String getFirstCert(String certChain) {
        final String result; 
        if (certChain.contains(";")) {
            result = certChain.split(";")[0];
        } else {
            result = certChain;
        }
        return result;
    }
}
