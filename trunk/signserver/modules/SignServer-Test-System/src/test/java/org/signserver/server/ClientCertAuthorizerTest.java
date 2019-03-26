/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.signserver.server;

import java.io.File;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.signserver.testutils.CLITestHelper;
import org.signserver.testutils.ModulesTestCase;

/**
 *
 * @author Marcus Lundblad
 * @version $Id$
 */
public class ClientCertAuthorizerTest {
    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(ClientCertAuthorizerTest.class);

    private final ModulesTestCase test = new ModulesTestCase();
    private final CLITestHelper cli = test.getAdminCLI();
    private final CLITestHelper client = test.getClientCLI();
    
    private final String SUBJECT_SERIALNUMBER = "723507815f93333";
    private final String SUBJECT_SERIALNUMBER_WITH_LEADING_ZERO = "0723507815f93333";
    private final String SUBJECT_SERIALNUMBER_UPPERCASE = "723507815F93333";
    private final String ISSUER_DN = "CN=DSS Root CA 10,OU=Testing,O=SignServer,C=SE";
    private final String DESCRIPTION = "Test auth client";
    
    @Test
    public void testSerialNumber() throws Exception {
        try {
            final int signerId = test.getSignerIdCMSSigner1();
            final String dss10Path = test.getSignServerHome().getAbsolutePath() +
                                           File.separator + "res" +
                                           File.separator + "test" +
                                           File.separator + "dss10";
            
            test.addCMSSigner1();
            test.getWorkerSession().setWorkerProperty(signerId, "AUTHTYPE",
                                                      "org.signserver.server.ClientCertAuthorizer");
            test.getWorkerSession().reloadConfiguration(signerId);
            
            // Add
            assertEquals("execute add", 0,
                    cli.execute("clients", "-worker", String.valueOf(signerId),
                    "-add", 
                    "-matchSubjectWithType", "CERTIFICATE_SERIALNO",
                    "-matchSubjectWithValue", SUBJECT_SERIALNUMBER,
                    "-matchIssuerWithValue", ISSUER_DN,
                    "-description", DESCRIPTION));
            test.getWorkerSession().reloadConfiguration(signerId);
            
            assertEquals("execute signdocument", 0,
                    client.execute("signdocument", "-workerid", String.valueOf(signerId),
                                   "-data", "foo", "-protocol", "CLIENTWS",
                                   "-host", "localhost",
                                   "-port", "8443",
                                   "-keystore",
                                   dss10Path + File.separator + "dss10_admin1.p12",
                                   "-keystorepwd", "foo123",
                                   "-truststore",
                                   dss10Path + File.separator + "dss10_truststore.jks",
                                   "-truststorepwd", "changeit"));
                                           
        } finally {
            test.removeWorker(test.getSignerIdCMSSigner1());
        }
    }
    
    @Test
    public void testSerialNumberWithLeadingZero() throws Exception {
        try {
            final int signerId = test.getSignerIdCMSSigner1();
            final String dss10Path = test.getSignServerHome().getAbsolutePath() +
                                           File.separator + "res" +
                                           File.separator + "test" +
                                           File.separator + "dss10";
            
            test.addCMSSigner1();
            test.getWorkerSession().setWorkerProperty(signerId, "AUTHTYPE",
                                                      "org.signserver.server.ClientCertAuthorizer");
            test.getWorkerSession().reloadConfiguration(signerId);
            
            // Add
            assertEquals("execute add", 0,
                    cli.execute("clients", "-worker", String.valueOf(signerId),
                    "-add", 
                    "-matchSubjectWithType", "CERTIFICATE_SERIALNO",
                    "-matchSubjectWithValue", SUBJECT_SERIALNUMBER_WITH_LEADING_ZERO,
                    "-matchIssuerWithValue", ISSUER_DN,
                    "-description", DESCRIPTION));
            test.getWorkerSession().reloadConfiguration(signerId);
            
            assertEquals("execute signdocument", 0,
                    client.execute("signdocument", "-workerid", String.valueOf(signerId),
                                   "-data", "foo", "-protocol", "CLIENTWS",
                                   "-host", "localhost",
                                   "-port", "8443",
                                   "-keystore",
                                   dss10Path + File.separator + "dss10_admin1.p12",
                                   "-keystorepwd", "foo123",
                                   "-truststore",
                                   dss10Path + File.separator + "dss10_truststore.jks",
                                   "-truststorepwd", "changeit"));
                                           
        } finally {
            test.removeWorker(test.getSignerIdCMSSigner1());
        }
    }
    
    @Test
    public void testSerialNumberUppercase() throws Exception {
        try {
            final int signerId = test.getSignerIdCMSSigner1();
            final String dss10Path = test.getSignServerHome().getAbsolutePath() +
                                           File.separator + "res" +
                                           File.separator + "test" +
                                           File.separator + "dss10";
            
            test.addCMSSigner1();
            test.getWorkerSession().setWorkerProperty(signerId, "AUTHTYPE",
                                                      "org.signserver.server.ClientCertAuthorizer");
            test.getWorkerSession().reloadConfiguration(signerId);
            
            // Add
            assertEquals("execute add", 0,
                    cli.execute("clients", "-worker", String.valueOf(signerId),
                    "-add", 
                    "-matchSubjectWithType", "CERTIFICATE_SERIALNO",
                    "-matchSubjectWithValue", SUBJECT_SERIALNUMBER_UPPERCASE,
                    "-matchIssuerWithValue", ISSUER_DN,
                    "-description", DESCRIPTION));
            test.getWorkerSession().reloadConfiguration(signerId);
            
            assertEquals("execute signdocument", 0,
                    client.execute("signdocument", "-workerid", String.valueOf(signerId),
                                   "-data", "foo", "-protocol", "CLIENTWS",
                                   "-host", "localhost",
                                   "-port", "8443",
                                   "-keystore",
                                   dss10Path + File.separator + "dss10_admin1.p12",
                                   "-keystorepwd", "foo123",
                                   "-truststore",
                                   dss10Path + File.separator + "dss10_truststore.jks",
                                   "-truststorepwd", "changeit"));
                                           
        } finally {
            test.removeWorker(test.getSignerIdCMSSigner1());
        }
    }
}
