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
package org.signserver.ejb.worker.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.signserver.common.GlobalConfiguration;
import org.signserver.common.IllegalRequestException;
import org.signserver.common.WorkerConfig;
import org.signserver.ejb.WorkerSessionBean;
import org.signserver.ejb.interfaces.IGlobalConfigurationSession;
import org.signserver.ejb.interfaces.IGlobalConfigurationSession.ILocal;
import org.signserver.ejb.interfaces.IWorkerSession;
import org.signserver.server.*;
import org.signserver.server.archive.Archiver;
import org.signserver.server.config.entities.WorkerConfigDataService;
import org.signserver.server.log.IWorkerLogger;
import org.signserver.server.timedservices.ITimedService;

/**
 * Session bean managing the worker life-cycle.
 *
 * @see WorkerFactory
 * @author Markus Kilås
 * @version $Id$
 */
@Stateless
public class WorkerManagerSessionBean implements IWorkerManagerSessionLocal {
    
    /** Logger for this class. */
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(WorkerManagerSessionBean.class);
    
    @PersistenceContext(unitName = "SignServerJPA")
    EntityManager em;
    
    private WorkerConfigDataService workerConfigService;
    
    private final WorkerFactory workerFactory = WorkerFactory.getInstance();
    
    @PostConstruct
    public void create() {
        workerConfigService = new WorkerConfigDataService(em);
    }

    @Override
    public IWorker getWorker(final int workerId, final IGlobalConfigurationSession globalSession) {
        return workerFactory.getWorker(workerId,
                workerConfigService, globalSession, this, new SignServerContext(
                em));
    }

    @Override
    public int getIdFromName(final String workerName, final IGlobalConfigurationSession globalSession) {
        return workerFactory.getWorkerIdFromName(workerName.
                toUpperCase(), workerConfigService, globalSession, this, new SignServerContext(
                em));
    }

    @Override
    public void reloadWorker(int workerId, WorkerSessionBean aThis, ILocal globalConfigurationSession) {
        workerFactory.reloadWorker(workerId,
                    workerConfigService, globalConfigurationSession, new SignServerContext(
                    em));
    }

    @Override
    public IWorkerLogger getWorkerLogger(int workerId, WorkerConfig awc) throws IllegalRequestException {
        return workerFactory.getWorkerLogger(workerId, awc, em);

    }

    @Override
    public IAuthorizer getAuthenticator(int workerId, String authenticationType, WorkerConfig awc) throws IllegalRequestException {
        return workerFactory.getAuthenticator(workerId,
                            authenticationType,
                            awc,
                            em);
    }

    @Override
    public IAccounter getAccounter(int workerId, WorkerConfig awc) throws IllegalRequestException {
        return workerFactory.getAccounter(workerId,
                                    awc,
                                    em);
    }

    @Override
    public List<Archiver> getArchivers(int workerId, WorkerConfig awc) throws IllegalRequestException {
        return workerFactory.getArchivers(workerId, awc, em);
    }

    @Override
    public void flush() {
        workerFactory.flush();
    }
    
    /**
     * @see org.signserver.ejb.interfaces.IWorkerSession#getWorkers(int)
     */
    @Override
    public List<Integer> getWorkers(int workerType, IGlobalConfigurationSession globalConfigurationSession) {
        ArrayList<Integer> retval = new ArrayList<Integer>();
        GlobalConfiguration gc = globalConfigurationSession.getGlobalConfiguration();

        Enumeration<String> en = gc.getKeyEnumeration();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            if (LOG.isTraceEnabled()) {
                LOG.trace("getWorkers, processing key : " + key);
            }
            if (key.startsWith("GLOB.WORKER")) {
                retval = (ArrayList<Integer>) getWorkerHelper(retval, key, workerType, false, globalConfigurationSession);
            }
            if (key.startsWith("GLOB.SIGNER")) {
                retval = (ArrayList<Integer>) getWorkerHelper(retval, key, workerType, true, globalConfigurationSession);
            }
        }
        return retval;
    }

    private List<Integer> getWorkerHelper(List<Integer> retval, String key, int workerType, boolean signersOnly, IGlobalConfigurationSession globalConfigurationSession) {

        String unScopedKey = key.substring("GLOB.".length());
        if (LOG.isTraceEnabled()) {
            LOG.trace("unScopedKey : " + unScopedKey);
        }
        String strippedKey = key.substring("GLOB.WORKER".length());
        if (LOG.isTraceEnabled()) {
            LOG.trace("strippedKey : " + strippedKey);
        }
        String[] splittedKey = strippedKey.split("\\.");
        if (LOG.isTraceEnabled()) {
            LOG.trace("splittedKey : " + splittedKey.length + ", " + splittedKey[0]);
        }
        if (splittedKey.length > 1) {
            if (splittedKey[1].equals("CLASSPATH")) {
                int id = Integer.parseInt(splittedKey[0]);
                if (workerType == GlobalConfiguration.WORKERTYPE_ALL) {
                    retval.add(new Integer(id));
                } else {
                    IWorker obj = getWorker(id, globalConfigurationSession);
                    if (workerType == GlobalConfiguration.WORKERTYPE_PROCESSABLE) {
                        if (obj instanceof IProcessable) {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Adding Signer " + id);
                            }
                            retval.add(new Integer(id));
                        }
                    } else {
                        if (workerType == GlobalConfiguration.WORKERTYPE_SERVICES && !signersOnly) {
                            if (obj instanceof ITimedService) {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Adding Service " + id);
                                }
                                retval.add(new Integer(id));
                            }
                        }
                    }
                }
            }
        }
        return retval;
    }
    
}
