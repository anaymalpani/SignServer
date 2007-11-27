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

package org.signserver.server;

import java.security.cert.X509Certificate;

import javax.persistence.EntityManager;

import org.ejbca.util.CertTools;
import org.signserver.common.GenericSignRequest;
import org.signserver.common.IProcessRequest;
import org.signserver.common.IllegalRequestException;
import org.signserver.common.SignServerException;
import org.signserver.common.WorkerConfig;

/**
 * Dummy authorizer used for testing and demonstration purposes
 * 
 * 
 * @author Philip Vendil 24 nov 2007
 *
 * @version $Id: DummyAuthorizer.java,v 1.1 2007-11-27 06:05:04 herrvendil Exp $
 */

public class DummyAuthorizer implements IAuthorizer {

	/**
	 * @see org.signserver.server.IAuthorizer#init(int, org.signserver.common.WorkerConfig, javax.persistence.EntityManager)
	 */
	public void init(int workerId, WorkerConfig config, EntityManager em)
			throws SignServerException {
		
		if(config.getProperties().getProperty("TESTAUTHPROP") == null){
			throw new SignServerException("Error initializing DummyAuthorizer, TESTAUTHPROP must be set");
		}

	}

	/**
	 * @see org.signserver.server.IAuthorizer#isAuthorized(org.signserver.common.IProcessRequest, java.security.cert.X509Certificate, java.lang.String)
	 */
	public void isAuthorized(IProcessRequest request,
			X509Certificate clientCert, String clientIP)
			throws SignServerException, IllegalRequestException {
		
		if(clientIP != null && !clientIP.equals("1.2.3.4")){
			throw new IllegalRequestException("Not authorized");
		}
		if(clientCert != null && CertTools.stringToBCDNString(clientCert.getSubjectDN().toString()).equals("CN=timestamptest,O=PrimeKey Solution AB")){
			throw new IllegalRequestException("Not authorized");
		}
		if(request instanceof GenericSignRequest && ((GenericSignRequest) request).getRequestID() != 1){
			throw new IllegalRequestException("Not authorized");
		}
		
	}

}
