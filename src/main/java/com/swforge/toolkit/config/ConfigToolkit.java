package com.swforge.toolkit.config;

import java.util.Map;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class ConfigToolkit {

    public class TTestConfig {
        private String target;
        private String dmIp;
        private String conf;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getDmIp() {
            return dmIp;
        }

        public void setDmIp(String dmIp) {
            this.dmIp = dmIp;
        }

        public String getConf() {
            return conf;
        }

        public void setConf(String conf) {
            this.conf = conf;
        }
    }

    public class TSetupJenkinsParam {
        private String[] jobTypes;
        private String revision;

        public TSetupJenkinsParam(String[] jobTypes, String revision) {
            this.jobTypes = jobTypes;
            this.revision = revision;
        }
    }

    private String defaultProject;
    private String defaultBranch;
    private String userId;
    private String userPass;
    private String ip;
    private String jUserId;
    private String jUserPass;
    private boolean verbose;
    private TTestConfig testConfig;
    private Map<String, Map<String, TSetupJenkinsParam>> jenkinsSetupInfo;

    public String getDefaultProject() {
        return defaultProject;
    }

    public void setDefaultProject(String defaultProject) {
        this.defaultProject = defaultProject;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getjUserId() {
        return jUserId;
    }

    public void setJUserId(String jUserId) {
        this.jUserId = jUserId;
    }

    public String getjUserPass() {
        return jUserPass;
    }

    public void setJUserPass(String jUserPass) {
        this.jUserPass = jUserPass;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setjUserId(String jUserId) {
        this.jUserId = jUserId;
    }

    public void setjUserPass(String jUserPass) {
        this.jUserPass = jUserPass;
    }

    public TTestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TTestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public Map<String, Map<String, TSetupJenkinsParam>> getJenkinsSetupInfo() {
        return jenkinsSetupInfo;
    }

    public void setJenkinsSetupInfo(Map<String, Map<String, TSetupJenkinsParam>> jenkinsSetupInfo) {
        this.jenkinsSetupInfo = jenkinsSetupInfo;
    }
}
