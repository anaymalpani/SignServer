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
package org.signserver.web;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.signserver.common.CompileTimeSettings;

/**
 * JSF managed bean exposing settings to the JSF pages. 
 * TODO: remove this and change SettingsBean to JSF managed bean as this is duplicate of SettingsBean.
 *
 * @author Vinay Singh
 * @version $Id$
 *
 */
public class SettingsNGBean {
    
    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(SettingsNGBean.class);

    /** Key in signservercompile.properties. */
    private static final String ADMINWEB_ENABLED_AND_AVAILABLE = "adminweb.enabled.available";
    private static final String WEBDOC_ENABLED = "webdoc.enabled";
    private static final String WEB_ADMINGUI_DIST_ENABLED = "web.admingui.dist.enabled";
    private static final String WEB_ADMINGUI_DIST_FILE = "web.admingui.dist.file";
    private static final String WEB_CLIENTCLI_DIST_ENABLED = "web.clientcli.dist.enabled";
    private static final String WEB_CLIENTCLI_DIST_FILE = "web.clientcli.dist.file";
    private static final String HTTPSERVER_EXTERNAL_PRIVHTTPS = "httpserver.external.privhttps";

    private final CompileTimeSettings settings = CompileTimeSettings.getInstance();
    
    private String healthCheckURL;

    public SettingsNGBean() {
    }

    /**
     * @return If the web documentation is enabled.
     */
    public boolean isAdminWebEnabledAndAvailable() {
        final String enabled = settings.getProperty(ADMINWEB_ENABLED_AND_AVAILABLE);
        return enabled != null && Boolean.parseBoolean(enabled);
    }

    /**
     * @return If the web documentation is enabled.
     */
    public boolean isWebDocEnabled() {
        final String enabled = settings.getProperty(WEBDOC_ENABLED);
        return enabled != null && Boolean.parseBoolean(enabled);
    }

    public boolean isWebAdminGUIDistEnabled() {
        final String enabled = settings.getProperty(WEB_ADMINGUI_DIST_ENABLED);
        return enabled != null && Boolean.parseBoolean(enabled);
    }

    public boolean isWebClientCLIDistEnabled() {
        final String enabled = settings.getProperty(WEB_CLIENTCLI_DIST_ENABLED);
        return enabled != null && Boolean.parseBoolean(enabled);
    }

    public File getAdminGUIDistFile() {
        final String fileName = settings.getProperty(WEB_ADMINGUI_DIST_FILE);
        if (LOG.isDebugEnabled()) {
            LOG.debug("AdminGUI dist file: " + fileName);
        }
        return fileName == null ? null : new File(fileName);
    }

    public File getClientCLIDistFile() {
        final String fileName = settings.getProperty(WEB_CLIENTCLI_DIST_FILE);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Client CLI dist file: " + fileName);
        }
        return fileName == null ? null : new File(fileName);
    }

    public boolean isWebAdminGUIDistAvailable() {
        final boolean result;
        if (!isWebAdminGUIDistEnabled()) {
            result = false;
        } else {
            final File file = getAdminGUIDistFile();
            if (file == null) {
                result = false;
            } else {
                result = file.exists() && file.isFile();
            }
        }
        return result;
    }

    public boolean isWebClientCLIDistAvailable() {
        final boolean result;
        if (!isWebClientCLIDistEnabled()) {
            result = false;
        } else {
            final File file = getClientCLIDistFile();
            if (file == null) {
                result = false;
            } else {
                result = file.exists() && file.isFile();
            }
        }
        return result;
    }

    public String getWebAdminGUIDistSize() {
        return String.format("%.2f MB", getAdminGUIDistFile().length() / 1000000f);
    }

    public String getWebClientCLIDistSize() {
        return String.format("%.2f MB", getClientCLIDistFile().length() / 1000000f);
    }

    /**
     * Port used by SignServer public web to construct a correct URL.
     * @return The port number
     */
    public int getExternalPrivateHttpsPort() {
        int value = 8443;
        try {
            value = Integer.parseInt(settings.getProperty(HTTPSERVER_EXTERNAL_PRIVHTTPS));
        } catch (NumberFormatException e) { // NOPMD
            LOG.warn("\"httpserver.external.privhttps\" is not a decimal number. Using default value: " + value);
        }
        return value;
    }
    
    /**
     * Host name used by SignServer public web to construct a correct URL.
     *
     * @param request HTTPServetRequest
     * @return The host name
     * @throws java.net.URISyntaxException
     */
    public String getHostName(HttpServletRequest request) throws URISyntaxException {
        URI uri = new URI(request.getRequestURL().toString());
        return uri.getHost();
    }
    
    public String getAdminWebPrivateHttpsLink() {
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String contextPath = externalContext.getRequestContextPath();
        String adminWebContextPath = contextPath.concat("/adminweb/");

        try {
            final URL url =
                    new URL("https", externalContext.getRequestServerName(),
                            getExternalPrivateHttpsPort(), adminWebContextPath);

            return url.toExternalForm();
        } catch (MalformedURLException ex) {
            LOG.error("Malformed URL");
            throw new RuntimeException(ex);
        }
    }

}
