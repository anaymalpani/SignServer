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
package org.signserver.server.dispatchers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import org.signserver.common.CryptoTokenOfflineException;
import org.signserver.common.IllegalRequestException;
import org.signserver.common.NoSuchWorkerException;
import org.signserver.common.ProcessRequest;
import org.signserver.common.ProcessResponse;
import org.signserver.common.RequestContext;
import org.signserver.common.ServiceLocator;
import org.signserver.common.SignServerException;
import org.signserver.common.WorkerConfig;
import org.signserver.common.WorkerIdentifier;
import org.signserver.ejb.interfaces.DispatcherProcessSessionLocal;
import org.signserver.server.IServices;
import org.signserver.server.UsernamePasswordClientCredential;
import org.signserver.server.WorkerContext;
import org.signserver.server.log.AdminInfo;

/**
 * Dispatching requests based on username with mapping in config.
 *
 * Properties:<br/>
 * USERNAME_MAPPING = Comma separated list of mappings from username:workername.
 * 
 * user1:worker1, user2:worker2
 *
 * @author Markus Kilås
 * @version $Id$
 */
public class UserMappedDispatcher extends BaseDispatcher {

    /** Log4j instance for this class. */
    private static final Logger LOG = Logger.getLogger(
            UserMappedDispatcher.class);

    /** Property WORKERS. */
    private static final String PROPERTY_USERNAME_MAPPING = "USERNAME_MAPPING";

    /** Workersession. */
    private DispatcherProcessSessionLocal workerSession;

    /** Mapping. */
    private Map<String, String> mappings;

    /** Configuration errors. */
    private LinkedList<String> configErrors;
    
    private String name;

    @Override
    public void init(final int workerId, final WorkerConfig config,
            final WorkerContext workerContext, final EntityManager workerEM) {
        super.init(workerId, config, workerContext, workerEM);
        configErrors = new LinkedList<String>();
        
        name = config.getProperty("NAME");

        mappings = new HashMap<String, String>();
        final String workersValue = config.getProperty(PROPERTY_USERNAME_MAPPING);
        if (workersValue == null) {
            configErrors.add("Property " + PROPERTY_USERNAME_MAPPING + " missing!");
        } else {
            if (!workersValue.trim().isEmpty()) {
                for (String mapping : workersValue.split(",")) {
                    final String[] item = mapping.split(":");
                    if (item.length == 2) {
                        mappings.put(item[0].trim(), item[1].trim());
                    } else {
                        configErrors.add("Syntax error in property " + PROPERTY_USERNAME_MAPPING);
                    }
                }
            }
        }
        this.workerSession = getWorkerSession();
    }
    
    protected DispatcherProcessSessionLocal getWorkerSession() {
        if (workerSession == null) {
            try {
                workerSession = ServiceLocator.getInstance().lookupLocal(
                        DispatcherProcessSessionLocal.class);
            } catch (NamingException ex) {
                LOG.error("Unable to lookup worker session", ex);
            }
        }
        return workerSession;
    }

    @Override
    public ProcessResponse processData(final ProcessRequest signRequest,
            final RequestContext requestContext) throws IllegalRequestException,
            CryptoTokenOfflineException, SignServerException {
        final ProcessResponse response;
        
        if (!configErrors.isEmpty()) {
            throw new SignServerException("Worker is misconfigured");
        }

        // TODO: Look for loops

        final RequestContext nextContext = requestContext.copyWithNewLogMap();

        final String username = ((UsernamePasswordClientCredential) requestContext.get(RequestContext.CLIENT_CREDENTIAL_PASSWORD)).getUsername();
        final String workerName = mappings.get(username);
        
        // Mark request comming from a dispatcher so the DispatchedAuthorizer can be used
        nextContext.put(RequestContext.DISPATCHER_AUTHORIZED_CLIENT, true);
        
        if (workerName == null) {
            LOG.info("No worker for username: " + username);
            throw new IllegalRequestException("No worker for the specified username");
        }
        
        if (name.equals(workerName)) {
            LOG.warn("Ignoring dispatching to it self (worker "
                    + workerName + ")");
            throw new SignServerException("Dispatcher configured to dispatch to itself");
        } else {
            try {
                response = workerSession.process(new AdminInfo("Client user", null, null),
                        new WorkerIdentifier(workerName), signRequest,
                        nextContext);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Dispatched to worker: "
                            + workerName + " (" + workerName + ")");
                }
            } catch (NoSuchWorkerException ex) {
                throw new SignServerException("Worker is misconfigured", ex);
            }
        }
        return response;
    }

    @Override
    protected List<String> getFatalErrors(IServices services) {
        final LinkedList<String> errors = new LinkedList<String>(super.getFatalErrors(services));
        errors.addAll(configErrors);
        return errors;
    }
}
