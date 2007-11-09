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


package org.signserver.common;

import java.io.PrintStream;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Class used when responding to the SignSession.getStatus() method, represents
 * the status of a specific signer
 * @author Philip Vendil
 *
 * $Id: SignerStatus.java,v 1.3 2007-11-09 15:45:50 herrvendil Exp $
 */

public class SignerStatus extends WorkerStatus{

	public static final int STATUS_ACTIVE  = 1;
	public static final int STATUS_OFFLINE = 2;
	
	private static final long serialVersionUID = 1L;

	private int tokenStatus = 0;
	private Certificate signerCertificate = null;
	
	/** 
	 * Main constuctor
	 */
	public SignerStatus(int tokenStatus, SignerConfig config, Certificate signerCertificate){
		super(config.getWorkerConfig());
		this.tokenStatus = tokenStatus;
	    this.signerCertificate = signerCertificate;
	}

	/**
	 * @return Returns the tokenStatus.
	 */
	public int getTokenStatus() {
		return tokenStatus;
	}

	 
	/**
	 * Method used to retrieve the currently used signercertficate.
	 * Use this method when checking status and not from config, since the cert isn't always in db.
	 * @return
	 */
	public Certificate getSignerCertificate(){
		return signerCertificate;
	}

	@Override
	public void displayStatus(int workerId, PrintStream out, boolean complete) {
		out.println("Status of Signer with Id " + workerId + " is :\n" +
				"  SignToken Status : "+signTokenStatuses[getTokenStatus()] + " \n\n" );

		if(complete){    	
			out.println("Active Properties are :");


			if(getActiveSignerConfig().getProperties().size() == 0){
				out.println("  No properties exists in active configuration\n");
			}

			Enumeration<?> propertyKeys = getActiveSignerConfig().getProperties().keys();
			while(propertyKeys.hasMoreElements()){
				String key = (String) propertyKeys.nextElement();
				out.println("  " + key + "=" + getActiveSignerConfig().getProperties().getProperty(key) + "\n");
			}        		

			out.println("\n");

			out.println("Active Authorized Clients are are (Cert DN, IssuerDN):");
			Iterator<?> iter =  new SignerConfig(getActiveSignerConfig()).getAuthorizedClients().iterator();
			while(iter.hasNext()){
				AuthorizedClient client = (AuthorizedClient) iter.next();
				out.println("  " + client.getCertSN() + ", " + client.getIssuerDN() + "\n");
			}
			if(getSignerCertificate() == null){
				out.println("Error: No Signer Certificate have been uploaded to this signer.\n");	
			}else{
				out.println("The current configuration use the following signer certificate : \n");
				printCert((X509Certificate) getSignerCertificate(),out );
			}
		}		
	}
		
	
}
