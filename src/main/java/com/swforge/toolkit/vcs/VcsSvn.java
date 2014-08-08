package com.swforge.toolkit.vcs;

import com.swforge.toolkit.config.ConfigToolkit;
import com.swforge.toolkit.config.ConfigUtils;
import org.tmatesoft.svn.core.SVNCancelException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.auth.SVNPasswordAuthentication;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.dav.http.HTTPNativeNTLMAuthentication;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.tmatesoft.svn.core.wc.SVNEventAction.RESTORE;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public class VcsSvn implements IVcs {

    SVNClientManager svnClientManager;
    SVNUpdateClient svnUpdateClient;
    ISVNAuthenticationManager svnAuthenticationManager;

    public VcsSvn() {
        System.setProperty("svnkit.http.methods", "Basic");
        String user = ConfigUtils.getFullUserId();
        String pass = ConfigUtils.getUserPass();
//        svnAuthenticationManager = SVNWCUtil.createDefaultAuthenticationManager(user,pass);
//        SVNPasswordAuthentication svnPasswordAuthentication = new SVNPasswordAuthentication()
        svnAuthenticationManager = new BasicAuthenticationManager(user,pass);
        svnClientManager = SVNClientManager.newInstance();
        svnClientManager.setAuthenticationManager(svnAuthenticationManager);
        svnUpdateClient = svnClientManager.getUpdateClient();
    }

    static ISyncLocalCallback syncLocalCallback;

    @Override
    public void syncLocal(String url, String localPath, ISyncLocalCallback callback) throws Exception {

        syncLocalCallback = callback;

        svnUpdateClient.setEventHandler(new ISVNEventHandler() {

            TSyncResult syncResult = new TSyncResult();
            List<TStatusInfo> infoList = new ArrayList<TStatusInfo>();

            @Override
            public void handleEvent(SVNEvent event, double progress) throws SVNException {
                System.out.format("%s progress, %f\n", event.toString(), progress);
                if (event.getAction() == SVNEventAction.RESTORE || event.getAction() == SVNEventAction.UPDATE_ADD) {
                    infoList.add(new TStatusInfo(
                            TStatus.EAdded,
                            event.getFile().getPath()
                    ));
                }
                if (event.getAction() == SVNEventAction.UPDATE_COMPLETED) {
                    syncResult.revision = Long.toString(event.getRevision());
                    syncResult.destination = event.getFile().getPath();
                    syncResult.infoList = new TStatusInfo[infoList.size()];
                    infoList.toArray(syncResult.infoList);
                    syncLocalCallback.cb(0, syncResult);
                }
            }

            @Override
            public void checkCancelled() throws SVNCancelException {

            }
        });

        svnUpdateClient.doCheckout(
                SVNURL.parseURIEncoded(url),
                new File(localPath),
                SVNRevision.HEAD,
                SVNRevision.HEAD,
                SVNDepth.INFINITY,
                true);
    }
}
