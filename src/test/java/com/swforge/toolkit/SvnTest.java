package com.swforge.toolkit;

import org.junit.Test;
import org.tmatesoft.svn.core.SVNCancelException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.*;

import java.io.File;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class SvnTest {

    @Test
    public void testCheckout() throws SVNException {
        SVNClientManager svnClientManager = SVNClientManager.newInstance();
        SVNUpdateClient svnUpdateClient = svnClientManager.getUpdateClient();
        String test = "test";
        svnUpdateClient.setEventHandler(new ISVNEventHandler() {

            @Override
            public void handleEvent(SVNEvent event, double progress) throws SVNException {
                System.out.format("%s progress, %f\n", event.toString(), progress);
            }

            @Override
            public void checkCancelled() throws SVNCancelException {

            }
        });
        // https://svn.apache.org/repos/asf/
        svnUpdateClient.doCheckout(SVNURL.parseURIDecoded("https://svn.apache.org/repos/asf/"),
                new File("C:\\temp\\Module"),
                SVNRevision.HEAD,
                SVNRevision.HEAD,
                true);
    }
}
