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

package org.signserver.protocol.validationservice.ws;

import java.util.Date;

import org.signserver.validationservice.common.Validation;

/**
 * WS representation of a Validation
 * 
 * 
 * @author Philip Vendil 2 dec 2007
 *
 * @version $Id: ValidationResponse.java,v 1.1 2007-12-02 20:35:18 herrvendil Exp $
 */

public class ValidationResponse {
	
	private Validation.Status status;
	private String statusMessage;
	private Date validationDate;
	private Date revocationDate;
	private int revocationReason;
	
	
	public ValidationResponse(Validation validation) {
		super();
		this.status = validation.getStatus();
		this.statusMessage = validation.getStatusMessage();
		this.validationDate = validation.getValidationDate();
		this.revocationDate = validation.getRevokedDate();
		this.revocationReason = validation.getRevokationReason();
	}
	
	public ValidationResponse() {
		super();
	}

	/**
	 * @return the validStatus
	 */
	public Validation.Status getStatus() {
		return status;
	}

	/**
	 * @param validStatus the validStatus to set
	 */
	public void setStatus(Validation.Status status) {
		this.status = status;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the validationDate
	 */
	public Date getValidationDate() {
		return validationDate;
	}

	/**
	 * @param validationDate the validationDate to set
	 */
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	/**
	 * @return the revocationDate
	 */
	public Date getRevocationDate() {
		return revocationDate;
	}

	/**
	 * @param revocationDate the revocationDate to set
	 */
	public void setRevocationDate(Date revocationDate) {
		this.revocationDate = revocationDate;
	}

	/**
	 * @return the revocationReason
	 */
	public int getRevocationReason() {
		return revocationReason;
	}

	/**
	 * @param revocationReason the revocationReason to set
	 */
	public void setRevocationReason(int revocationReason) {
		this.revocationReason = revocationReason;
	}
	
}
