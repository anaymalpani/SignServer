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
package org.signserver.module.openpgp.signer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.signserver.client.cli.ClientCLI;
import org.signserver.common.AbstractCertReqData;
import org.signserver.common.PKCS10CertReqInfo;
import org.signserver.common.SignServerUtil;
import org.signserver.common.WorkerConfig;
import org.signserver.common.WorkerIdentifier;
import org.signserver.common.WorkerStatus;
import org.signserver.common.WorkerType;
import org.signserver.common.util.PathUtil;
import org.signserver.ejb.interfaces.WorkerSession;
import org.signserver.openpgp.utils.ClearSignedFileProcessorUtils;
import org.signserver.testutils.CLITestHelper;
import org.signserver.testutils.ModulesTestCase;

/**
 * System tests for the OpenPGPSigner.
 *
 * @author Marcus Lundblad
 * @version $Id$
 */
public class OpenPGPSignerTest {
    /** Logger for this class */
    private static final Logger LOG = Logger.getLogger(OpenPGPSignerTest.class);

    private static final int WORKER_OPENPGPSIGNER = 40000;
    private static final int WORKER_OPENPGPPLAINSIGNER = 41000;
    private static final String SIGNER00004 = "signer00004";
    private static final String SIGNER00004_KEYID = "EFF9ED546884D030";
    private static final String SIGNER00003 = "signer00003";
    private static final String SIGNER00003_KEYID = "F7B50A4D55F6E703";
    private static final String SIGNER00002 = "signer00002";
    private static final String SIGNER00002_KEYID = "E3091F74636A925E";
    private static final String SIGNER00001 = "signer00001";
    private static final String SIGNER00001_KEYID = "4B821662F54A5923";
    private static final String RSA_KEY_ALGORITHM = String.valueOf(PublicKeyAlgorithmTags.RSA_SIGN);
    private static final String ECDSA_KEY_ALGORITHM = String.valueOf(PublicKeyAlgorithmTags.ECDSA);
    private static final String DSA_KEY_ALGORITHM = String.valueOf(PublicKeyAlgorithmTags.DSA);

    private final File sampleBinaryFile;

    private final ModulesTestCase testCase = new ModulesTestCase();
    private final WorkerSession workerSession = testCase.getWorkerSession();
    private static final CLITestHelper CLI = new CLITestHelper(ClientCLI.class);

    public OpenPGPSignerTest() throws FileNotFoundException {
        final File home = PathUtil.getAppHome();
        sampleBinaryFile = new File(home, "res/test/pdf/sample.pdf"); // Let's use any binary file as input
    }

    
    @BeforeClass
    public static void setUpClass() throws Exception {
        SignServerUtil.installBCProvider();
    }
    
    /**
     * Test that generating a certification works both when generating
     * for DEFAULTKEY and for another key, with an existing certificate
     * set in PGPPUBLICKEY, installing the new public certificate and and
     * setting PGPPUBLICKEY to the new certificate and updating DEFAULTKEY.
     * The worker should be active in both cases.
     *
     * @throws Exception
     */
    @Test
    public void testGeneratePublicKeyForNoDefaultKey() throws Exception {
        final int workerId = 42;
        final String workerName = "OpenPGPSigner-gen-non-default";
        try {
            final WorkerIdentifier wi = new WorkerIdentifier(workerId);
            testCase.addSigner("org.signserver.module.openpgp.signer.OpenPGPSigner",
                             workerId, workerName, true);
            testCase.getWorkerSession().setWorkerProperty(workerId, "DEFAULTKEY",
                                                        "signer00001");
            testCase.getWorkerSession().setWorkerProperty(workerId,
                                                        "DETACHEDSIGNATURE",
                                                        "true");
            testCase.getWorkerSession().reloadConfiguration(workerId);

            PKCS10CertReqInfo certReqInfo =
                    new PKCS10CertReqInfo("SHA256withRSA", "User1", null);
            AbstractCertReqData requestData = (AbstractCertReqData)
                    testCase.getWorkerSession().getCertificateRequest(wi,
                                                                    certReqInfo,
                                                                    false);

            String pgpPublicKey = requestData.toArmoredForm();
            testCase.getWorkerSession().setWorkerProperty(workerId, "PGPPUBLICKEY",
                                                        pgpPublicKey);
            testCase.getWorkerSession().reloadConfiguration(workerId);

            WorkerStatus status = testCase.getWorkerSession().getStatus(wi);
            assertTrue("Worker active: " + status.getFatalErrors().toString(),
                       status.getFatalErrors().isEmpty());

            // generate certification for another key
            certReqInfo = new PKCS10CertReqInfo("SHA256withRSA", "User2", null);
            requestData = (AbstractCertReqData)
                    testCase.getWorkerSession().getCertificateRequest(wi,
                                                                    certReqInfo,
                                                                    false,
                                                                    "signer00003");
            pgpPublicKey = requestData.toArmoredForm();
            testCase.getWorkerSession().setWorkerProperty(workerId, "PGPPUBLICKEY",
                                                        pgpPublicKey);
            testCase.getWorkerSession().setWorkerProperty(workerId, "DEFAULTKEY",
                                                        "signer00003");
            testCase.getWorkerSession().reloadConfiguration(workerId);

            status = testCase.getWorkerSession().getStatus(wi);
            assertTrue("Worker active: " + status.getFatalErrors().toString(),
                       status.getFatalErrors().isEmpty());
        } finally {
            testCase.removeWorker(workerId);
        }
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it with client-side option.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSide() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it with client-side option.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSideBinaryForm() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, false);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * clear-text signature and verifying it with client-side option.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_clientSide() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it with client-side option.
     * Using RSA key and SHA-512.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSideRSA_SHA512() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA512", HashAlgorithmTags.SHA512, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * clear-text signature and verifying it with client-side option.
     * Using RSA key and SHA-512.
     *
     * @throws Exception
     */
    @Test 
    public void testAddUserIdClearTextSignAndVerify_clientSideRSA_SHA512() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA512", HashAlgorithmTags.SHA512, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it with client-side option.
     * Using DSA.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSideDSA() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00004, SIGNER00004_KEYID, DSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * clear-text signature and verifying it with client-side option.
     * Using DSA.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_clientSideDSA() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00004, SIGNER00004_KEYID, DSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it with client-side option.
     * Using an ECDSA key.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSideECDSA() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00002, SIGNER00002_KEYID, ECDSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * clear-text signature and verifying it with client-side option.
     * Using an ECDSA key.
     *
     * @throws Exception
     */
    @Test 
    public void testAddUserIdClearTextSignAndVerify_clientSideECDSA() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00002, SIGNER00002_KEYID, ECDSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    /**
     * Tests detached signing with a different key, client-side.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSide_otherKeyId() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00001, SIGNER00001_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests clear-text signing with a different key, client-side.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_clientSide_otherKeyId() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00001, SIGNER00001_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests with a incorrect id key, client-side and expects detached signing to fail.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_clientSide_incorrectKeyId() throws Exception {
        addUserIdDetachedSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00001, "INCORRECT_KEY_ID", RSA_KEY_ALGORITHM, ClientCLI.RETURN_ERROR, true);
    }
    
    /**
     * Tests with a incorrect id key, client-side and expects clear-text signing to fail.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_clientSide_incorrectKeyId() throws Exception {
        addUserIdClearTextSignAndVerify(true, "SHA256", HashAlgorithmTags.SHA256, SIGNER00001, "INCORRECT_KEY_ID", RSA_KEY_ALGORITHM, ClientCLI.RETURN_ERROR, true);
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_serverSide() throws Exception {
        addUserIdDetachedSignAndVerify(false, null, HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests adding a User Id to the public key, sign something producing 
     * clear-text signature and verifying it.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_serverSide() throws Exception {
        addUserIdClearTextSignAndVerify(false, null, HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    /**
     * Tests adding a User Id to the public key, sign something producing 
     * detached signature and verifying it.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_serverSideBinaryForm() throws Exception {
        addUserIdDetachedSignAndVerify(false, null, HashAlgorithmTags.SHA256, SIGNER00003, SIGNER00003_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, false);
    }
    
    /**
     * Tests detached sign with a different key, server-side.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdDetachedSignAndVerify_serverSide_otherKeyId() throws Exception {
        addUserIdDetachedSignAndVerify(false, null, HashAlgorithmTags.SHA256, SIGNER00001, SIGNER00001_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }
    
    /**
     * Tests clear-text sign with a different key, server-side.
     *
     * @throws Exception
     */
    @Test
    public void testAddUserIdClearTextSignAndVerify_serverSide_otherKeyId() throws Exception {
        addUserIdClearTextSignAndVerify(false, null, HashAlgorithmTags.SHA256, SIGNER00001, SIGNER00001_KEYID, RSA_KEY_ALGORITHM, ClientCLI.RETURN_SUCCESS, true);
    }

    private void setupOpenPGPSignerOnlyProperties(final int workerId,
                                                  final String keyAlias,
                                                  final boolean detachedSignature,
                                                  final boolean armored)
            throws Exception {
        // Setup worker
        workerSession.setWorkerProperty(workerId, WorkerConfig.TYPE, WorkerType.PROCESSABLE.name());
        workerSession.setWorkerProperty(workerId, WorkerConfig.IMPLEMENTATION_CLASS, "org.signserver.module.openpgp.signer.OpenPGPSigner");
        workerSession.setWorkerProperty(workerId, "NAME", "OpenPGPSigner" + workerId);
        workerSession.setWorkerProperty(workerId, "AUTHTYPE", "NOAUTH");
        workerSession.setWorkerProperty(workerId, "CRYPTOTOKEN", testCase.getSignerNameDummy1());
        workerSession.setWorkerProperty(workerId, "DEFAULTKEY", keyAlias);
        workerSession.setWorkerProperty(workerId, "DETACHEDSIGNATURE", String.valueOf(detachedSignature));
        workerSession.setWorkerProperty(workerId, "RESPONSE_FORMAT",
                                        armored ? "ARMORED" : "BINARY");
    }

    private void setupOpenPGPPlainSignerOnlyProperties(final int workerId, final String keyAlias) throws Exception {
        // Setup worker
        workerSession.setWorkerProperty(workerId, WorkerConfig.TYPE, WorkerType.PROCESSABLE.name());
        workerSession.setWorkerProperty(workerId, WorkerConfig.IMPLEMENTATION_CLASS, "org.signserver.module.openpgp.enterprise.signer.OpenPGPPlainSigner");
        workerSession.setWorkerProperty(workerId, "NAME", "OpenPGPPlainSigner" + workerId);
        workerSession.setWorkerProperty(workerId, "AUTHTYPE", "NOAUTH");
        workerSession.setWorkerProperty(workerId, "CRYPTOTOKEN", testCase.getSignerNameDummy1());
        workerSession.setWorkerProperty(workerId, "DEFAULTKEY", keyAlias);       
    }

    /**
     * Tests adding a User Id to the public key, sign something using CLI
     * producing detached signature and verifying it.
     *
     * @param clientSide if client-side option should be used
     * @throws Exception
     */
    private void addUserIdDetachedSignAndVerify(final boolean clientSide,
                                                final String clientSideDigestAlgorithm,
                                                final int expectedHashAlgorithm,
                                                final String keyAlias,
                                                final String keyId,
                                                final String keyAlgorithm,
                                                final int expectedOutcome,
                                                final boolean armored)
            throws Exception {
        LOG.info("addUserIdDetachedSignAndVerify-" + (clientSide ? "clientSide" : "serverSide"));
        int workerId = 0;
        File outFile = null;
        try {
            outFile = File.createTempFile("outfile-", ".asc");
            testCase.addDummySigner1(true);
            if (clientSide) {
                workerId = WORKER_OPENPGPPLAINSIGNER;
                setupOpenPGPPlainSignerOnlyProperties(WORKER_OPENPGPPLAINSIGNER, keyAlias);
                if (clientSideDigestAlgorithm == null) {
                    throw new Exception("Must specify digest algorithm for testing client-side");
                }
            } else {
                workerId = WORKER_OPENPGPSIGNER;
                setupOpenPGPSignerOnlyProperties(WORKER_OPENPGPSIGNER, keyAlias,
                                                 true, armored);
                if (clientSideDigestAlgorithm != null) {
                    throw new Exception("Must not specify digest algorithm for testing server-side");
                }
            }
            workerSession.reloadConfiguration(testCase.getSignerIdDummy1());
            workerSession.reloadConfiguration(WORKER_OPENPGPSIGNER);

            // Generate the public key
            final String userId = "Worker (" + workerId + ") <worker@example.com>";
            final PKCS10CertReqInfo certReqInfo = new PKCS10CertReqInfo("SHA256WithRSA", userId, null);
            AbstractCertReqData csr = (AbstractCertReqData) workerSession.getCertificateRequest(new WorkerIdentifier(workerId), certReqInfo, false);
            assertNotNull(csr);
            String publicKeyArmored = csr.toArmoredForm();
            assertTrue("public key header: " + publicKeyArmored, publicKeyArmored.contains("-----BEGIN PGP PUBLIC KEY BLOCK-----"));
            assertTrue("public key footer: " + publicKeyArmored, publicKeyArmored.contains("-----END PGP PUBLIC KEY BLOCK-----"));

            // Store the updated public key
            workerSession.setWorkerProperty(workerId, "PGPPUBLICKEY", publicKeyArmored);
            workerSession.reloadConfiguration(workerId);

            // Check the status has no errors and that the user id is printed
            WorkerStatus status = workerSession.getStatus(new WorkerIdentifier(workerId));
            assertEquals("fatal errors", "[]", status.getFatalErrors().toString());
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            status.displayStatus(new PrintStream(bout), true);
            String statusOutput = bout.toString(StandardCharsets.UTF_8.toString());
            assertTrue("key contains user id: " + statusOutput, statusOutput.contains(userId));

            // Test signing
            final byte[] originalData = FileUtils.readFileToByteArray(sampleBinaryFile);
            if (clientSide) {
                assertEquals("Status code", expectedOutcome,
                         CLI.execute("signdocument", "-workerid",
                                     String.valueOf(workerId),
                                     "-infile", sampleBinaryFile.getAbsolutePath(),
                                     "-outfile", outFile.getAbsolutePath(),
                                     "-clientside",
                                     "-filetype", "PGP",
                                     "-digestalgorithm", clientSideDigestAlgorithm,
                                    "-extraoption", "KEY_ID=" + keyId,
                                    "-extraoption", "KEY_ALGORITHM=" + keyAlgorithm,
                                    "-extraoption", "RESPONSE_FORMAT=" +
                                            (armored ? "ARMORED" : "BINARY"),
                                    "-extraoption", "DETACHED_SIGNATURE=TRUE"));
            } else {
                assertEquals("Status code", expectedOutcome,
                         CLI.execute("signdocument", "-workerid",
                                     String.valueOf(workerId),
                                     "-infile", sampleBinaryFile.getAbsolutePath(),
                                     "-outfile", outFile.getAbsolutePath()));
            }

            // Verify signature if signing was successful         
            if (expectedOutcome == 0) {
                PGPSignature sig =
                        verifyDetachedSignature(originalData, outFile, publicKeyArmored,
                                        armored);
                assertEquals("hash algorithm", expectedHashAlgorithm, sig.getHashAlgorithm());
                assertEquals("key id", new BigInteger(keyId, 16).longValue(), sig.getKeyID());
                assertEquals("key algorithm", Integer.parseInt(keyAlgorithm), sig.getKeyAlgorithm());
            }
        } finally {
            testCase.removeWorker(testCase.getSignerIdDummy1());
            if (workerId != 0) {
                testCase.removeWorker(workerId);
            }
            FileUtils.deleteQuietly(outFile);
        }
    }
    
    /**
     * Tests adding a User Id to the public key, sign something using CLI
     * producing clear-text signature and verifying it.
     *
     * @param clientSide if client-side option should be used
     * @throws Exception
     */
    private void addUserIdClearTextSignAndVerify(final boolean clientSide,
                                                final String clientSideDigestAlgorithm,
                                                final int expectedHashAlgorithm,
                                                final String keyAlias,
                                                final String keyId,
                                                final String keyAlgorithm,
                                                final int expectedOutcome,
                                                final boolean armored)
            throws Exception {
        LOG.info("addUserIdClearTextSignAndVerify-" + (clientSide ? "clientSide" : "serverSide"));
        int workerId = 0;
        File outFile = null;
        try {
            outFile = File.createTempFile("outfile-", ".asc");
            testCase.addDummySigner1(true);
            if (clientSide) {
                workerId = WORKER_OPENPGPPLAINSIGNER;
                setupOpenPGPPlainSignerOnlyProperties(WORKER_OPENPGPPLAINSIGNER, keyAlias);
                if (clientSideDigestAlgorithm == null) {
                    throw new Exception("Must specify digest algorithm for testing client-side");
                }
            } else {
                workerId = WORKER_OPENPGPSIGNER;
                setupOpenPGPSignerOnlyProperties(WORKER_OPENPGPSIGNER, keyAlias,
                                                 false, armored);
                if (clientSideDigestAlgorithm != null) {
                    throw new Exception("Must not specify digest algorithm for testing server-side");
                }
            }
            workerSession.reloadConfiguration(testCase.getSignerIdDummy1());
            workerSession.reloadConfiguration(WORKER_OPENPGPSIGNER);

            // Generate the public key
            final String userId = "Worker (" + workerId + ") <worker@example.com>";
            final PKCS10CertReqInfo certReqInfo = new PKCS10CertReqInfo("SHA256WithRSA", userId, null);
            AbstractCertReqData csr = (AbstractCertReqData) workerSession.getCertificateRequest(new WorkerIdentifier(workerId), certReqInfo, false);
            assertNotNull(csr);
            String publicKeyArmored = csr.toArmoredForm();
            assertTrue("public key header: " + publicKeyArmored, publicKeyArmored.contains("-----BEGIN PGP PUBLIC KEY BLOCK-----"));
            assertTrue("public key footer: " + publicKeyArmored, publicKeyArmored.contains("-----END PGP PUBLIC KEY BLOCK-----"));

            // Store the updated public key
            workerSession.setWorkerProperty(workerId, "PGPPUBLICKEY", publicKeyArmored);
            workerSession.reloadConfiguration(workerId);

            // Check the status has no errors and that the user id is printed
            WorkerStatus status = workerSession.getStatus(new WorkerIdentifier(workerId));
            assertEquals("fatal errors", "[]", status.getFatalErrors().toString());
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            status.displayStatus(new PrintStream(bout), true);
            String statusOutput = bout.toString(StandardCharsets.UTF_8.toString());
            assertTrue("key contains user id: " + statusOutput, statusOutput.contains(userId));

            // Test signing            
            if (clientSide) {
                assertEquals("Status code", expectedOutcome,
                         CLI.execute("signdocument", "-workerid",
                                     String.valueOf(workerId),
                                     "-infile", sampleBinaryFile.getAbsolutePath(),
                                     "-outfile", outFile.getAbsolutePath(),
                                     "-clientside",
                                     "-filetype", "PGP",
                                     "-digestalgorithm", clientSideDigestAlgorithm,
                                    "-extraoption", "KEY_ID=" + keyId,
                                    "-extraoption", "KEY_ALGORITHM=" + keyAlgorithm,
                                    "-extraoption", "RESPONSE_FORMAT=" +
                                            (armored ? "ARMORED" : "BINARY"),
                                    "-extraoption", "DETACHED_SIGNATURE=FALSE"));
            } else {
                assertEquals("Status code", expectedOutcome,
                         CLI.execute("signdocument", "-workerid",
                                     String.valueOf(workerId),
                                     "-infile", sampleBinaryFile.getAbsolutePath(),
                                     "-outfile", outFile.getAbsolutePath()));
            }

            // Verify signature if signing was successful         
            if (expectedOutcome == 0) {
                PGPSignature sig
                        = verifyClearTextSignature(outFile, publicKeyArmored);
                assertEquals("hash algorithm", expectedHashAlgorithm, sig.getHashAlgorithm());
                assertEquals("key id", new BigInteger(keyId, 16).longValue(), sig.getKeyID());
                assertEquals("key algorithm", Integer.parseInt(keyAlgorithm), sig.getKeyAlgorithm());
            }
        } finally {
            testCase.removeWorker(testCase.getSignerIdDummy1());
            if (workerId != 0) {
                testCase.removeWorker(workerId);
            }
            FileUtils.deleteQuietly(outFile);
        }
    }    

    private BCPGInputStream createInputStream(InputStream in, boolean armored) throws IOException {
        return new BCPGInputStream(armored ? new ArmoredInputStream(in) : in);
    }
    
    private PGPSignature verifyDetachedSignature(byte[] originalData, final File outFile,
                                         final String publicKeyArmored,
                                         final boolean armored) throws IOException, PGPException {
        final byte[] signedBytes = FileUtils.readFileToByteArray(outFile);
        PGPSignature sig;

        try (InputStream in = createInputStream(new ByteArrayInputStream(signedBytes), armored)) {
            JcaPGPObjectFactory objectFactory = new JcaPGPObjectFactory(in);
            PGPSignatureList p3 = (PGPSignatureList) objectFactory.nextObject();
            sig = p3.get(0);
        }

        final PGPPublicKey pgpPublicKey = OpenPGPUtils.parsePublicKeys(publicKeyArmored).get(0);
        sig.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), pgpPublicKey);
        sig.update(originalData);
        assertTrue("verified", sig.verify());

        return sig;
    }    
    
    private PGPSignature verifyClearTextSignature(final File outFile, final String publicKeyArmored) throws IOException, PGPException, SignatureException {
        File resultFile = null;
        PGPSignature sig;
        try {
            final byte[] signedBytes = FileUtils.readFileToByteArray(outFile);
            resultFile = File.createTempFile("resultFile", "txt");

            String signed = new String(signedBytes, StandardCharsets.US_ASCII);
            assertTrue("expecting armored: " + signed, signed.startsWith("-----BEGIN PGP SIGNED MESSAGE-----"));

            ArmoredInputStream aIn = new ArmoredInputStream(new ByteArrayInputStream(signedBytes));
            ByteArrayOutputStream lineOut;
            int lookAhead;
            try (OutputStream out = new BufferedOutputStream(new FileOutputStream(resultFile))) {
                lineOut = new ByteArrayOutputStream();
                lookAhead = ClearSignedFileProcessorUtils.readInputLine(lineOut, aIn);
                byte[] lineSep = ClearSignedFileProcessorUtils.getLineSeparator();
                if (lookAhead != -1 && aIn.isClearText()) {
                    byte[] line = lineOut.toByteArray();
                    out.write(line, 0, ClearSignedFileProcessorUtils.getLengthWithoutSeparatorOrTrailingWhitespace(line));
                    out.write(lineSep);

                    while (lookAhead != -1 && aIn.isClearText()) {
                        lookAhead = ClearSignedFileProcessorUtils.readInputLine(lineOut, lookAhead, aIn);

                        line = lineOut.toByteArray();
                        out.write(line, 0, ClearSignedFileProcessorUtils.getLengthWithoutSeparatorOrTrailingWhitespace(line));
                        out.write(lineSep);
                    }
                } else {
                    // a single line file
                    if (lookAhead != -1) {
                        byte[] line = lineOut.toByteArray();
                        out.write(line, 0, ClearSignedFileProcessorUtils.getLengthWithoutSeparatorOrTrailingWhitespace(line));
                        out.write(lineSep);
                    }
                }
            }

            JcaPGPObjectFactory pgpFact = new JcaPGPObjectFactory(aIn);
            PGPSignatureList p3 = (PGPSignatureList) pgpFact.nextObject();
            sig = p3.get(0);

            final PGPPublicKey pgpPublicKey = OpenPGPUtils.parsePublicKeys(publicKeyArmored).get(0);
            sig.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), pgpPublicKey);

            try (InputStream sigIn = new BufferedInputStream(new FileInputStream(resultFile))) {
                lookAhead = ClearSignedFileProcessorUtils.readInputLine(lineOut, sigIn);

                ClearSignedFileProcessorUtils.processLine(sig, lineOut.toByteArray());

                if (lookAhead != -1) {
                    do {
                        lookAhead = ClearSignedFileProcessorUtils.readInputLine(lineOut, lookAhead, sigIn);

                        sig.update((byte) '\r');
                        sig.update((byte) '\n');

                        ClearSignedFileProcessorUtils.processLine(sig, lineOut.toByteArray());
                    } while (lookAhead != -1);
                }
            }

            assertTrue("verified", sig.verify());

            return sig;
        } finally {
            FileUtils.deleteQuietly(resultFile);
        }
    }
    

}