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
package org.signserver.client.cli;

import java.io.IOException;
import java.io.OutputStream;
import org.signserver.common.CryptoTokenOfflineException;
import org.signserver.common.IllegalRequestException;
import org.signserver.common.SignServerException;

/**
 * Abstract implementation of DocumentValidator.
 *
 * @author Markus Kilås
 * @version $Id$
 */
public abstract class AbstractDocumentValidator implements DocumentValidator {

    private static final String ENCODING_NONE = "none";
    private static final String ENCODING_BASE64 = "base64";

    public AbstractDocumentValidator() {
    }

    public void validate(final byte[] data, final String encoding, 
            final OutputStream out) throws IllegalRequestException,
            CryptoTokenOfflineException, SignServerException, IOException {
        doValidate(data, encoding, out);
    }

    public void validate(final byte[] data, final String encoding) 
            throws IllegalRequestException, CryptoTokenOfflineException,
            SignServerException, IOException {
        validate(data, encoding, System.out);
    }

    public void validate(final byte[] data) throws IllegalRequestException,
            CryptoTokenOfflineException, SignServerException, IOException {
        validate(data, ENCODING_NONE, System.out);
    }

    public void validate(final byte[] data, final OutputStream out) 
            throws IllegalRequestException, CryptoTokenOfflineException,
            SignServerException, IOException {
        doValidate(data, ENCODING_NONE, out);
    }

    protected abstract void doValidate(final byte[] data, final String encoding,
            final OutputStream out) throws IllegalRequestException,
                CryptoTokenOfflineException, SignServerException,
                IOException;
}
