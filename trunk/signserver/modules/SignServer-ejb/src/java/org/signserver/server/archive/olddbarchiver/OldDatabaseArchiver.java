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
package org.signserver.server.archive.olddbarchiver;

import java.security.cert.X509Certificate;
import java.util.Map;
import org.apache.log4j.Logger;
import org.signserver.common.ArchiveDataVO;
import org.signserver.common.RequestContext;
import org.signserver.common.WorkerConfig;
import org.signserver.server.SignServerContext;
import org.signserver.server.archive.Archivable;
import org.signserver.server.archive.ArchiveException;
import org.signserver.server.archive.Archiver;
import org.signserver.server.archive.ArchiverInitException;
import org.signserver.server.archive.olddbarchiver.entities.ArchiveDataService;
import org.signserver.server.log.IWorkerLogger;

/**
 * Archiver only accepting responses and currently only supports Archivables of
 * class ArchiveDataArchivable. 
 * 
 * @author Markus Kilås
 * @version $Id$
 */
public class OldDatabaseArchiver implements Archiver {
    
    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(OldDatabaseArchiver.class);

    private ArchiveDataService dataService;
    
    private boolean base64Encoding;

    @Override
    public void init(int listIndex, WorkerConfig config, SignServerContext context) throws ArchiverInitException {
        dataService = new ArchiveDataService(context.getEntityManager());
        if (LOG.isDebugEnabled()) {
            LOG.debug("Archiver" + listIndex + " will use base64 encoding: " + base64Encoding);
        }
    }

    @Override
    public boolean archive(Archivable archivable, RequestContext requestContext)
            throws ArchiveException {
        final boolean archived;
        if (Archivable.TYPE_RESPONSE.equals(archivable.getType())
                && archivable instanceof ArchiveDataArchivable) {
            if (dataService == null) {
                throw new ArchiveException("Could not archive as archiver was not successfully initialized");
            }
            final ArchiveDataArchivable ada = (ArchiveDataArchivable) archivable;
            final Integer workerId = (Integer) requestContext.get(RequestContext.WORKER_ID);
            final X509Certificate certificate = (X509Certificate) requestContext.get(RequestContext.CLIENT_CERTIFICATE);
            final String remoteIp = (String) requestContext.get(RequestContext.REMOTE_IP);

            final String uniqueId;
            uniqueId = dataService.create(ArchiveDataVO.TYPE_RESPONSE,
                        workerId,
                        ada.getArchiveId(),
                        certificate,
                        remoteIp,
                            ada.getArchiveData());
            if (LOG.isDebugEnabled()) {
                LOG.debug("Archived with uniqueId: " + uniqueId);
            }
            Map<String, String> logMap = (Map<String, String>) requestContext.get(RequestContext.LOGMAP);
            String ids = logMap.get(IWorkerLogger.LOG_ARCHIVE_IDS);
            if (ids == null) {
                ids = uniqueId;
            } else {
                ids = ids + ", " + uniqueId;
            }
            logMap.put(IWorkerLogger.LOG_ARCHIVE_IDS, ids);
            
            archived = true;
        } else {
            archived = false;
        }
        return archived;
    }
}
