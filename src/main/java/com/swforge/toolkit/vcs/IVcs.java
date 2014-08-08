package com.swforge.toolkit.vcs;

import org.tmatesoft.svn.core.SVNException;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public interface IVcs {

    public enum TType {
        EKnown,
        ESvn,
        EGit,
        EMercurial
    }

    public enum TStatus {
        EUnknown,
        EAdded,
        EUpdated,
        ERemoved,
        EConflicted,
    }


    public class TStatusInfo {
        private TStatus status;
        private String path;

        public TStatusInfo(TStatus status, String path) {
            this.status = status;
            this.path = path;
        }

        public TStatus getStatus() {
            return status;
        }

        public void setStatus(TStatus status) {
            this.status = status;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public class TSyncResult {
        public String destination;
        public TStatusInfo[] infoList;
        public String revision;
    }

    public interface ISyncLocalCallback {
        void cb(int err, TSyncResult syncResult);
    }

    void syncLocal(String url, String localPath, ISyncLocalCallback callback) throws Exception;

}
