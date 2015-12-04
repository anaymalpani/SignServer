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

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Marcus Lundblad
 * @version $Id$
 */
public class SODProcessWorkerServlet extends HttpServlet {
        /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(SODProcessWorkerServlet.class);

    private static final String SOD_SERVLET_URL = "/sod";
    private static final String WORKER_URI_START = "/signserver/sodworker/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        final String workerName =
                ServletUtils.parseWorkerName(req, WORKER_URI_START);

        if (workerName == null) {
            // give a 404 error
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                           "No worker specified");
        } else {
            req.setAttribute(ServletUtils.WORKERNAME_PROPERTY_OVERRIDE,
                             workerName);
            // dispatch the message to the GeneralProcessServlet
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher =
                            context.getRequestDispatcher(SOD_SERVLET_URL);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Forwarding request to: " + SOD_SERVLET_URL);
            }

            dispatcher.forward(req, resp);
        }	
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
