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
package org.signserver.server.log;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Test;
import org.signserver.common.RequestContext;
import org.signserver.common.WorkerConfig;
import org.signserver.server.SignServerContext;

/**
 * Unit tests for the base worker logger implementation.
 * Tests the fatal errors mechanism.
 * 
 * @author Marcus Lundblad
 * @version $Id
 */
public class BaseWorkerLoggerUnitTest extends TestCase {
    
    /**
     * Test that no fatal error is included by default.
     * 
     * @throws Exception
     */
    @Test
    public void testNoErrors() throws Exception {
        final BaseWorkerLogger workerLogger = new BaseWorkerLogger() {
            @Override
            public void init(int workerId, WorkerConfig config, SignServerContext context) {
            }

            @Override
            public void log(AdminInfo adminInfo, Map<String, String> fields, RequestContext requestContext) throws WorkerLoggerException {
            }            
        };
        
        assertEquals("Should contain no errors",
                     0, workerLogger.getFatalErrors().size());
        assertFalse("Should not report errors", workerLogger.hasErrors());
    }
    
    /**
     * Test that adding an error using the base addFatalError method works.
     * 
     * @throws Exception 
     */
    @Test
    public void testOneError() throws Exception {
        final BaseWorkerLogger workerLogger = new BaseWorkerLogger() {
            @Override
            public void init(int workerId, WorkerConfig config, SignServerContext context) {
                addFatalError("An error");
            }

            @Override
            public void log(AdminInfo adminInfo, Map<String, String> fields, RequestContext requestContext) throws WorkerLoggerException {
            }            
        };
        
        workerLogger.init(0, null, null);
        
        assertEquals("Should contain one error",
                     1, workerLogger.getFatalErrors().size());
        assertTrue("Should contain the error",
                   workerLogger.getFatalErrors().contains("An error"));
    }
    
    /**
     * Test that overriding the getFatalErrors method works.
     * 
     * @throws Exception 
     */
    @Test
    public void testOverrideGetFatalErrors() throws Exception {
        final BaseWorkerLogger workerLogger = new BaseWorkerLogger() {
            @Override
            public void init(int workerId, WorkerConfig config, SignServerContext context) {
            }

            @Override
            public void log(AdminInfo adminInfo, Map<String, String> fields, RequestContext requestContext) throws WorkerLoggerException {
            }
            
            @Override
            public List<String> getFatalErrors() {
                return Arrays.asList("An overridden error");
            }
        };
        
        assertEquals("Should contain one error",
                     1, workerLogger.getFatalErrors().size());
        assertTrue("Should contain the error",
                   workerLogger.getFatalErrors().contains("An overridden error"));
    }
    
    /**
     * Test that overriding the getFatalErrors method and chaning up to super's
     * implementation retains the ability to add errors at the base level using
     * addFatalError.
     * 
     * @throws Exception 
     */
    @Test
    public void testOverrideGetFatalErrorAndUseSuper() throws Exception {
        final BaseWorkerLogger workerLogger = new BaseWorkerLogger() {
            @Override
            public void init(int workerId, WorkerConfig config, SignServerContext context) {
                addFatalError("Base error");
            }

            @Override
            public void log(AdminInfo adminInfo, Map<String, String> fields, RequestContext requestContext) throws WorkerLoggerException {
            }
            
            @Override
            public List<String> getFatalErrors() {
                List<String> errors = super.getFatalErrors();
                
                errors.add("Overridden error");
                return errors; 
            }
        };
        
        workerLogger.init(0, null, null);

        assertEquals("Should contain two errors",
                     2, workerLogger.getFatalErrors().size());
        assertTrue("Should contain the base error",
                   workerLogger.getFatalErrors().contains("Base error"));
        assertTrue("Should contain the overridden error",
                   workerLogger.getFatalErrors().contains("Overridden error"));
    }
}
