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
package org.signserver.ejb;

import javax.persistence.EntityManager;
import org.cesecore.audit.log.SecurityEventsLoggerSessionLocal;
import org.signserver.ejb.interfaces.DispatcherProcessSessionLocal;
import org.signserver.ejb.interfaces.InternalProcessSessionLocal;
import org.signserver.ejb.interfaces.ProcessSessionLocal;
import org.signserver.server.ServicesImpl;
import org.signserver.ejb.interfaces.WorkerSessionLocal;
import org.signserver.ejb.interfaces.GlobalConfigurationSessionLocal;
import org.signserver.statusrepo.StatusRepositorySessionLocal;

/**
 * ServicesImpl adding convenience method adding all services.
 * The purpose with the method is also to make sure that all new services are
 * added in all places.
 * 
 * @author Markus Kilås
 * @version $Id$
 */
public class AllServicesImpl extends ServicesImpl {
    
    /**
     * Add all services implementations.
     * @param em EntityManager
     * @param workerSession WorkerSession
     * @param processSession ProcessSessionLocal
     * @param globalConfigurationSession IGlobalConfigurationSession
     * @param logSession SecurityEventsLoggerSessionLocal
     * @param internalWorkerSession IInternalWorkerSession
     * @param dispatcherWorkerSession IDispatcherWorkerSession
     * @param statusRespositorySession IStatusRepositorySession
     */
    public void putAll(final EntityManager em,
            final WorkerSessionLocal workerSession,
            final ProcessSessionLocal processSession,
            final GlobalConfigurationSessionLocal globalConfigurationSession,
            final SecurityEventsLoggerSessionLocal logSession,
            final InternalProcessSessionLocal internalWorkerSession,
            final DispatcherProcessSessionLocal dispatcherWorkerSession,
            final StatusRepositorySessionLocal statusRespositorySession) {
        put(EntityManager.class, em);
        put(WorkerSessionLocal.class, workerSession);
        put(ProcessSessionLocal.class, processSession);
        put(GlobalConfigurationSessionLocal.class, globalConfigurationSession);
        put(SecurityEventsLoggerSessionLocal.class, logSession);
        put(InternalProcessSessionLocal.class, internalWorkerSession);
        put(DispatcherProcessSessionLocal.class, dispatcherWorkerSession);
        put(StatusRepositorySessionLocal.class, statusRespositorySession);
        // Add additional services here
    }
}
