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


package org.signserver.cli;


/**
 * removes an authorized user from a mail signer installation
 *
 * @version $Id$
 * @author Philip Vendil
 */
public class RemoveAuthorizedUserCommand extends BaseCommand {
	

    /**
     * Creates a new instance of RemoveAuthorizedClientCommand
     *
     * @param args command line arguments
     */
    public RemoveAuthorizedUserCommand(String[] args) {
        super(args);
    }

    /**
     * Runs the command
     *
     * @throws IllegalAdminCommandException Error in command args
     * @throws ErrorAdminCommandException Error running command
     */
    public void execute(String hostname) throws IllegalAdminCommandException, ErrorAdminCommandException {
        if (args.length != 2) {
	       throw new IllegalAdminCommandException("Usage: signserver removeauthorizeduser <username>\n" + 
	       		                                  "Example: signserver removeauthorizeduser user1\n\n");	       
	    }	
        try {                    	        	
        	String username = args[1];

        	this.getOutputStream().println("Removing the user with username " + username + " as authorized.\n");
        	this.getOutputStream().println("See current authorized users with the listauthorizedusers command, no need to activate configuration with reload.\n");
        	if(getCommonAdminInterface(hostname).removeAuthorizedUser(username)){
        		this.getOutputStream().println("  User removed.\n");	
        	}else{
        		this.getOutputStream().println("  Error: the given user doesn't seem to exist\n");
        	}        	        	
        	
    		this.getOutputStream().println("\n\n");
        	
        } catch (IllegalAdminCommandException e) {
        	throw e;  
        } catch (Exception e) {
        	throw new ErrorAdminCommandException(e);            
        }
    }

	public int getCommandType() {
		return TYPE_EXECUTEONMASTER;
	}
    // execute
}
