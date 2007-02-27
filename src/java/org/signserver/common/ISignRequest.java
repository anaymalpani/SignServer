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

import java.io.Serializable;

/**
 * Interface used for requests to SignSession.signData method. Should
 * be implemented by all types of signers.
 * 
 * 
 * @author Philip Vendil
 * $Id: ISignRequest.java,v 1.1 2007-02-27 16:18:11 herrvendil Exp $
 */

public interface ISignRequest extends Serializable{
	
	/**
	 * Should contain a unique request id used to identify the request
	 */
    public int getRequestID();

    
    /**
     * Should contain the data that should be signed.
     */
    public Object getSignRequestData();
}
