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
package org.signserver.client.cli.defaultimpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import javax.net.ssl.*;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.signserver.cli.spi.CommandFailureException;
import org.signserver.cli.spi.IllegalCommandArgumentsException;
import org.signserver.common.SignServerUtil;

/**
 * Handles keystore and truststore options from the command line as well
 * as setting them up for use with SSL.
 * 
 * @author Markus Kilås
 * @version $Id$
 */
public class KeyStoreOptions {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(KeyStoreOptions.class);

    /** ResourceBundle with internationalized StringS. */
    private static final ResourceBundle TEXTS = ResourceBundle.getBundle(
            "org/signserver/client/cli/defaultimpl/ResourceBundle");

    /** Default host */
    public static final String DEFAULT_HOST = "localhost";

    /** Default HTTP port. */
    public static final int DEFAULT_HTTP_PORT = 8080;

    /** Default public HTTPS port. */
    public static final int DEFAULT_PUBLIC_HTTPS_PORT = 8442;

    /** Default private HTTPS port. */
    public static final int DEFAULT_PRIVATE_HTTPS_PORT = 8443;

    /** Option TRUSTSTORE. */
    public static final String TRUSTSTORE = "truststore";

    /** Option TRUSTSTOREPWD. */
    public static final String TRUSTSTOREPWD = "truststorepwd";

    /** Option KEYSTORE. */
    public static final String KEYSTORE = "keystore";

    /** Option KEYSTOREPWD. */
    public static final String KEYSTOREPWD = "keystorepwd";

    /** Option KEYALIAS. */
    public static final String KEYALIAS = "keyalias";
    
    /** Option KEYSTORETYPE. */
    public static final String KEYSTORETYPE = "keystoretype";

    public static List<Option> getKeyStoreOptions() {
        return Arrays.asList(
            new Option(KeyStoreOptions.TRUSTSTORE, true, TEXTS.getString("TRUSTSTORE_DESCRIPTION")),
            new Option(KeyStoreOptions.TRUSTSTOREPWD, true, TEXTS.getString("TRUSTSTOREPWD_DESCRIPTION")),
            new Option(KeyStoreOptions.KEYSTORE, true, TEXTS.getString("KEYSTORE_DESCRIPTION")),
            new Option(KeyStoreOptions.KEYSTOREPWD, true, TEXTS.getString("KEYSTOREPWD_DESCRIPTION")),
            new Option(KeyStoreOptions.KEYALIAS, true, TEXTS.getString("KEYALIAS_DESCRIPTION")),
            new Option(KeyStoreOptions.KEYSTORETYPE, true, TEXTS.getString("KEYSTORETYPE_DESCRIPTION"))
        );
    }

    private File truststoreFile;
    private String truststorePassword;
    private File keystoreFile;
    private String keystorePassword;
    private String keyAlias;
    private String keystoreType;

    private KeyStore truststore;
    private KeyStore keystore;
    private boolean useHTTPS;
    private boolean usePrivateHTTPS;

    public void parseCommandLine(CommandLine line, ConsolePasswordReader passwordReader, PrintStream out)
            throws IOException, NoSuchAlgorithmException, CertificateException,
                   KeyStoreException, CommandFailureException {
        if (line.hasOption(KeyStoreOptions.TRUSTSTORE)) {
            truststoreFile = new File(line.getOptionValue(KeyStoreOptions.TRUSTSTORE, null));
        }
        if (line.hasOption(KeyStoreOptions.TRUSTSTOREPWD)) {
            truststorePassword = line.getOptionValue(KeyStoreOptions.TRUSTSTOREPWD, null);
        }
        if (line.hasOption(KeyStoreOptions.KEYSTORE)) {
            keystoreFile = new File(line.getOptionValue(KeyStoreOptions.KEYSTORE, null));
        }
        if (line.hasOption(KeyStoreOptions.KEYSTOREPWD)) {
            keystorePassword = line.getOptionValue(KeyStoreOptions.KEYSTOREPWD, null);
        }
        if (line.hasOption(KeyStoreOptions.KEYALIAS)) {
            keyAlias = line.getOptionValue(KeyStoreOptions.KEYALIAS, null);
        }
        if (line.hasOption(KeyStoreOptions.KEYSTORETYPE)) {
            keystoreType = line.getOptionValue(KeyStoreOptions.KEYSTORETYPE, null);
        }

        if (passwordReader != null) {
            // Prompt for truststore password if not given
            if (truststoreFile != null && truststorePassword == null) {
                for (int i = 0; i < 3; i++) {
                    out.print("Password for truststore: "); 
                    out.flush();
                    truststorePassword = new String(passwordReader.readPassword());
                    try {
                        KeyStore keystore = KeyStore.getInstance("JKS");
                        keystore.load(new FileInputStream(truststoreFile), truststorePassword.toCharArray());
                        break;
                    } catch (IOException ex) {
                        if (ex.getCause() instanceof UnrecoverableKeyException) {
                            if (i >= 2) {
                                throw ex;
                            }
                            continue;
                        } else {
                            throw ex;
                        }
                    }
                }
            }
            // Prompt for keystore password if not given
            if (keystoreFile != null && keystorePassword == null && !"PKCS11".equals(keystoreType)) {
                for (int i = 0; i < 3; i++) {
                    out.print("Password for keystore: ");
                    out.flush();
                    
                    keystorePassword = new String(passwordReader.readPassword());
                    try {
                        KeyStore keystore = KeyStore.getInstance("JKS");
                        keystore.load(new FileInputStream(keystoreFile), keystorePassword.toCharArray());
                        break;
                    } catch (IOException ex) {
                        if (ex.getCause() instanceof UnrecoverableKeyException) {
                            if (i >= 2) {
                                throw ex;
                            }
                            continue;
                        } else {
                            throw ex;
                        }
                    }
                }
            }
        }
    }
    
    public void validateOptions() throws IllegalCommandArgumentsException {
        if (truststoreFile != null && truststorePassword == null) {
            throw new IllegalCommandArgumentsException("Missing -truststorepwd");
        } else if (keystoreFile != null && keystorePassword == null && !"PKCS11".equals(keystoreType)) {
            throw new IllegalCommandArgumentsException("Missing -keystorepwd");
        } else if (keystoreType != null) {
            switch (keystoreType) {
                case "PKCS11":
                case "JKS":
                    break;
                default:
                    throw new IllegalCommandArgumentsException("Unsupported keystore type. Supported values are: [JKS, PKCS11]");
            }
        }
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public File getKeystoreFile() {
        return keystoreFile;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public File getTruststoreFile() {
        return truststoreFile;
    }

    public String getTruststorePassword() {
        return truststorePassword;
    }

    public SSLSocketFactory setupHTTPS(final ConsolePasswordReader passwordReader, final PrintStream out) {
        // If we should use HTTPS
        if (truststoreFile != null) {
            try {
                truststore = loadKeyStore(truststoreFile, truststorePassword);
            } catch (KeyStoreException | NoSuchAlgorithmException |
                     CertificateException | IOException ex) {
                throw new RuntimeException("Could not load truststore", ex);
            }
        }
        
        SignServerUtil.installBCProvider();

        // If we should use client authenticated HTTPS
        if (keystoreFile != null) {
            try {
                if ("PKCS11".equals(keystoreType)) {
                    KeyStore.CallbackHandlerProtection pp = new KeyStore.CallbackHandlerProtection(new CallbackHandler() {

                        @Override
                        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                            for (Callback callback : callbacks) {
                                if (callback instanceof PasswordCallback) {
                                    try {
                                        final PasswordCallback pc = (PasswordCallback) callback;
                                        out.print("Password for keystore: ");
                                        out.flush();

                                        keystorePassword = new String(passwordReader.readPassword());

                                        if (keystorePassword != null) {
                                            pc.setPassword(keystorePassword.toCharArray());
                                        }
                                    } catch (CommandFailureException ex) {
                                        throw new IOException(ex);
                                    }
                                } else {
                                    throw new UnsupportedCallbackException(callback, "Unrecognized Callback");
                                }
                            }
                        }
                    });                
                    keystore = getLoadedKeystorePKCS11("PKCS11", keystoreFile, keystorePassword != null ? keystorePassword.toCharArray() : null, pp);
                } else {
                    keystore = loadKeyStore(keystoreFile, keystorePassword);
                }
            } catch (KeyStoreException | NoSuchAlgorithmException |
                     CertificateException | IOException ex) {
                throw new RuntimeException("Could not load keystore", ex);
            }
        }

        if (truststore == null && keystore == null) {
            useHTTPS = false;
        } else if (keystore == null) {
            useHTTPS = true;
        } else {
            if (truststore == null) {
                truststore = keystore;
            }
            useHTTPS = true;
            usePrivateHTTPS = true;
        }

        if (useHTTPS) {
            try {
                return setDefaultSocketFactory(truststore, keystore, keyAlias,
                    keystorePassword == null ? null : keystorePassword.toCharArray());
            } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | UnrecoverableKeyException ex) {
                throw new RuntimeException("Could not setup HTTPS", ex);
            }
        } else {
            return null;
        }
    }

    private static KeyStore loadKeyStore(final File truststoreFile,
            final String truststorePassword) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(new FileInputStream(truststoreFile), truststorePassword.toCharArray());
        return keystore;
    }

    private static SSLSocketFactory setDefaultSocketFactory(final KeyStore truststore,
            final KeyStore keystore, String keyAlias, char[] keystorePassword) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, UnrecoverableKeyException {

        final TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(truststore);

        final KeyManager[] keyManagers;
        if (keystore == null) {
            keyManagers = null;
        } else {
            if (keyAlias == null) {
                keyAlias = keystore.aliases().nextElement();
            }
            final KeyManagerFactory kKeyManagerFactory
                    = KeyManagerFactory.getInstance("SunX509");
            kKeyManagerFactory.init(keystore, keystorePassword);
            keyManagers = kKeyManagerFactory.getKeyManagers();
            for (int i = 0; i < keyManagers.length; i++) {
                if (keyManagers[i] instanceof X509KeyManager) {
                    keyManagers[i] = new AliasKeyManager(
                            (X509KeyManager) keyManagers[i], keyAlias);
                }
            }
        }

        final SSLContext context = SSLContext.getInstance("TLS");
        context.init(keyManagers, tmf.getTrustManagers(), new SecureRandom());

        SSLSocketFactory factory = context.getSocketFactory();
        
        return factory;
    }

    public boolean isUseHTTPS() {
        return useHTTPS;
    }

    public boolean isUsePrivateHTTPS() {
        return usePrivateHTTPS;
    }

    public void setUsePrivateHTTPS(boolean usePrivateHTTPS) {
        this.usePrivateHTTPS = usePrivateHTTPS;
    }

    public String getKeystoreType() {
        return keystoreType;
    }

    public void setKeystoreType(String keystoreType) {
        this.keystoreType = keystoreType;
    }


    private static KeyStore getLoadedKeystorePKCS11(final String name, final File library, final char[] authCode, KeyStore.CallbackHandlerProtection callbackHandlerProtection) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keystore;

        final InputStream config = new ByteArrayInputStream(
            new StringBuilder().append("name=").append(name).append("\n")
                    .append("library=").append(library.getAbsolutePath()).append("\n")
                    .append("slot=2\n") // TODO
                    .append("showInfo=true")
                    .toString().getBytes());

        try {
                final Class<?> klass = Class.forName("sun.security.pkcs11.SunPKCS11");
                Provider provider;

                try {
                    /* try getting the Java 9+ configure method first
                     * if this fails, fall back to the old way, calling the
                     * constructor
                     */
                    final Class[] paramString = new Class[1];    
                    paramString[0] = String.class;
                    final Method method =
                            Provider.class.getDeclaredMethod("configure",
                                                             paramString);
                    final String configString =
                            getSunP11ConfigStringFromInputStream(config);

                    provider = getPKCS11ProviderUsingConfigMethod(method, configString);
                } catch (NoSuchMethodException e) {
                    // find constructor taking one argument of type InputStream
                    Class<?>[] parTypes = new Class[1];
                    parTypes[0] = InputStream.class;

                    Constructor<?> ctor = klass.getConstructor(parTypes);	        
                    Object[] argList = new Object[1];
                    argList[0] = config;
                    provider = (Provider) ctor.newInstance(argList);
                }

                Security.addProvider(provider);

                final KeyStore.Builder builder = KeyStore.Builder.newInstance("PKCS11",
                        provider, callbackHandlerProtection);

                keystore = builder.getKeyStore();
                keystore.load(null, authCode);

                final Enumeration<String> e = keystore.aliases();
                while( e.hasMoreElements() ) {
                    final String keyAlias = e.nextElement();
                    if (LOG.isDebugEnabled()) {
                        X509Certificate cert = (X509Certificate) keystore.getCertificate(keyAlias);
                        LOG.debug("******* keyAlias: " + keyAlias
                                + ", certificate: "
                                + (cert == null ? "null" : cert.getSubjectDN().getName()));
                    }
                }
                //LOADED_KESTORES.put(keystoreName, keystore);
        } catch (NoSuchMethodException nsme) {
            throw new KeyStoreException("Could not find constructor for keystore provider", nsme);
        } catch (InstantiationException ie) {
            throw new KeyStoreException("Failed to instantiate keystore provider", ie);
        } catch (ClassNotFoundException ncdfe) {
            throw new KeyStoreException("Unsupported keystore provider", ncdfe);
        } catch (InvocationTargetException ite) {
            throw new KeyStoreException("Could not initialize provider", ite);
        } catch (Exception e) {
            throw new KeyStoreException("Error", e);
        }

        return keystore;
    }

    private static Provider getPKCS11ProviderUsingConfigMethod(final Method configMethod,
                                                               final String config)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final Provider prototype = Security.getProvider("SunPKCS11");
        final Provider provider = (Provider) configMethod.invoke(prototype, config);
        
        return provider;
    }
    
    private static String getSunP11ConfigStringFromInputStream(final InputStream is) throws IOException {
        final StringBuilder configBuilder = new StringBuilder();
        
        /* we need to prepend -- to indicate to the configure() method
         * that the config is treated as a string
         */
        configBuilder.append("--").append(IOUtils.toString(is));
        
        return configBuilder.toString();
    }    
}
