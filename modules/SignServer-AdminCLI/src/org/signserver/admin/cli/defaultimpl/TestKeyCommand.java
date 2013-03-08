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
package org.signserver.admin.cli.defaultimpl;

import java.util.Collection;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.ejbca.ui.cli.util.ConsolePasswordReader;
import org.signserver.cli.spi.CommandFailureException;
import org.signserver.cli.spi.IllegalCommandArgumentsException;
import org.signserver.cli.spi.UnexpectedCommandFailureException;
import org.signserver.common.KeyTestResult;

/**
 * Command used to test one or more keys associated with a Crypto Token.
 *
 * @author Markus Kilås
 * @version $Id$
 */
public class TestKeyCommand extends AbstractAdminCommand {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(TestKeyCommand.class);

    /** Option authcode. */
    public static final String AUTHCODE = "authcode";

    /** Option verbose. */
    public static final String VERBOSE = "v";

    /** The command line options. */
    private static final Options OPTIONS;

    private static String USAGE = "Usage: signserver testkey <worker id | worker name> [alias or \"all\"] [-v]\n"
            + "Leaving out \"alias\" and \"all\" will use the value in DEFAULTKEY.\n\n"
            + "Specifying \"all\" tests all keys in the slot .\n"
            + "Example 1: signserver testkey 71\n"
            + "Example 2: signserver testkey 71 myKey1\n"
            + "Example 3: signserver testkey 71 all";

    private char[] authCode;
    private boolean verbose;
    
    static {
        OPTIONS = new Options();
        OPTIONS.addOption(AUTHCODE, true, "Authentication code");
        OPTIONS.addOption(VERBOSE, false, "Verbose output");
    }

    @Override
    public String getDescription() {
        return "Tests one or more keys in a Crypto Token";
    }

    @Override
    public String getUsages() {
        return USAGE;
    }
    
    /**
     * Reads all the options from the command line.
     *
     * @param line The command line to read from
     */
    private void parseCommandLine(final CommandLine line) {
        if (line.hasOption(AUTHCODE)) {
            authCode = line.getOptionValue(AUTHCODE, null).toCharArray();
        }
        verbose = line.hasOption(VERBOSE);
    }

    /**
     * Checks that all mandadory options are given.
     */
    private void validateOptions() {
        // No mandatory options.
    }

    @Override
    public int execute(String... args) throws IllegalCommandArgumentsException, CommandFailureException, UnexpectedCommandFailureException {
        try {
            // Parse the command line
            parseCommandLine(new GnuParser().parse(OPTIONS, args));
        } catch (ParseException ex) {
            throw new IllegalArgumentException(ex.getLocalizedMessage(), ex);
        }
        validateOptions();
        
        if (args.length < 1) {
            throw new IllegalCommandArgumentsException(USAGE);
        }
        try {
            if (authCode == null) {
                getOutputStream().print("Enter authorization code: ");
                // Read the password, but mask it so we don't display it on the console
                final ConsolePasswordReader r = new ConsolePasswordReader();
                authCode = r.readPassword();
            }

            int signerId = getWorkerId(args[0]);
            checkThatWorkerIsProcessable(signerId);

            String alias = null;

            if (args.length >= 2) {
                alias = args[1];
            }

            if (alias == null) {
                LOG.info(
                        "Will test key with alias defined by DEFAULTKEY property");
            } else if ("all".equals(alias)) {
                LOG.info("Will test all keys");
            } else {
                LOG.info("Test key with alias " + alias + ".");
            }

            final Collection<KeyTestResult> results = getWorkerSession().testKey(signerId, alias, authCode);

            for (KeyTestResult key : results) {
                final StringBuilder sb = new StringBuilder();
                sb.append(key.getAlias());
                sb.append(" \t");
                sb.append(key.isSuccess() ? "SUCCESS" : "FAILURE");
                sb.append(" \t");
                if (verbose) {
                    sb.append(" \t");
                    sb.append(key.getPublicKeyHash());
                }
                sb.append(" \t");
                sb.append(key.getStatus());
                System.out.println(sb.toString());
            }
            return 0;

        } catch (Exception e) {
            throw new UnexpectedCommandFailureException(e);
        }
    }
}
