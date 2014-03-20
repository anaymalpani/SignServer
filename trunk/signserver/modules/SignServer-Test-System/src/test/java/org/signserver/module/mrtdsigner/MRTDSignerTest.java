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
package org.signserver.module.mrtdsigner;

import java.io.File;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Cipher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.signserver.common.GenericSignRequest;
import org.signserver.common.GenericSignResponse;
import org.signserver.common.MRTDSignRequest;
import org.signserver.common.MRTDSignResponse;
import org.signserver.common.RequestContext;
import org.signserver.common.SignServerUtil;
import org.signserver.common.SignerStatus;
import org.signserver.common.WorkerConfig;
import org.signserver.testutils.ModulesTestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Document me!
 * 
 * @version $Id$
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MRTDSignerTest extends ModulesTestCase {

    @Before
    public void setUp() throws Exception {
        SignServerUtil.installBCProvider();
    }

    @Test
    public void test00SetupDatabase() throws Exception {
        setProperties(new File(getSignServerHome(), "modules/SignServer-Module-MRTDSigner/src/conf/junittest-part-config.properties"));
        workerSession.reloadConfiguration(7890);
    }

    /*
     * Test method for 'org.signserver.server.MRTDSigner.signData(ISignRequest)'
     */
    @Test
    public void test01SignData() throws Exception {
        int reqid = 12;
        ArrayList<byte[]> signrequests = new ArrayList<byte[]>();

        byte[] signreq1 = "Hello World".getBytes();
        byte[] signreq2 = "Hello World2".getBytes();
        signrequests.add(signreq1);
        signrequests.add(signreq2);

        MRTDSignResponse res = (MRTDSignResponse) workerSession.process(7890, new MRTDSignRequest(reqid, signrequests), new RequestContext());
        assertTrue(res != null);
        assertTrue(reqid == res.getRequestID());
        Certificate signercert = res.getSignerCertificate();
        assertNotNull(signercert);

        Cipher c = Cipher.getInstance("RSA", "BC");
        c.init(Cipher.DECRYPT_MODE, signercert);

        byte[] signres1 = c.doFinal((byte[]) ((ArrayList<?>) res.getProcessedData()).get(0));

        if (!arrayEquals(signreq1, signres1)) {
            assertTrue("First MRTD doesn't match with request", false);
        }

        byte[] signres2 = c.doFinal((byte[]) ((ArrayList<?>) res.getProcessedData()).get(1));

        if (!arrayEquals(signreq2, signres2)) {
            assertTrue("Second MRTD doesn't match with request", false);
        }
    }

    private boolean arrayEquals(byte[] signreq2, byte[] signres2) {
        boolean retval = true;

        if (signreq2.length != signres2.length) {
            return false;
        }

        for (int i = 0; i < signreq2.length; i++) {
            if (signreq2[i] != signres2[i]) {
                return false;
            }
        }
        return retval;
    }

    /*
     * Test method for 'org.signserver.server.MRTDSigner.getStatus()'
     */
    @Test
    public void test02GetStatus() throws Exception {
        SignerStatus stat = (SignerStatus) workerSession.getStatus(7890);
        assertTrue(stat.getTokenStatus() == SignerStatus.STATUS_ACTIVE);

    }

    @Test
    public void test03GenericSignData() throws Exception {
        int reqid = 13;
        byte[] signreq1 = "Hello World".getBytes();

        GenericSignResponse res = (GenericSignResponse) workerSession.process(7890, new GenericSignRequest(reqid, signreq1), new RequestContext());
        assertTrue(res != null);
        assertTrue(reqid == res.getRequestID());
        Certificate signercert = res.getSignerCertificate();
        assertNotNull(signercert);

        Cipher c = Cipher.getInstance("RSA", "BC");
        c.init(Cipher.DECRYPT_MODE, signercert);

        byte[] signres1 = c.doFinal(res.getProcessedData());

        assertTrue(Arrays.equals(signreq1, signres1));
    }

    /**
     * Test that setting INCLUDE_CERTIFICATE_LEVELS gives a config error.
     * 
     * @throws Exception
     */
    @Test
    public void test04IncludeCertificateLevelsNotSupported() throws Exception {
       try {
           workerSession.setWorkerProperty(7890, WorkerConfig.PROPERTY_INCLUDE_CERTIFICATE_LEVELS, "2");
           workerSession.reloadConfiguration(7890);
           
           final List<String> errors = workerSession.getStatus(7890).getFatalErrors();
           
           assertTrue("Should contain error", errors.contains(WorkerConfig.PROPERTY_INCLUDE_CERTIFICATE_LEVELS + " is not supported."));
       } finally {
           workerSession.removeWorkerProperty(7890, WorkerConfig.PROPERTY_INCLUDE_CERTIFICATE_LEVELS);
           workerSession.reloadConfiguration(7890);
       }
    }
    
    @Test
    public void test99TearDownDatabase() throws Exception {
        removeWorker(7890);
    }
}
