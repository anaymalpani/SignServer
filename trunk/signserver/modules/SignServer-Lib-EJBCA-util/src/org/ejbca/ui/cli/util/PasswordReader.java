/*************************************************************************
 *                                                                       *
 *  EJBCA: The OpenSource Certificate Authority                          *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.ejbca.ui.cli.util;

import java.io.IOException;

/** Interface for reading passwords from the console or from other sources
 * 
 * @version $Id: PasswordReader.java 5585 2008-05-01 20:55:00Z anatom $
 */
public interface PasswordReader {
    char[] readPassword() throws IOException;
}
