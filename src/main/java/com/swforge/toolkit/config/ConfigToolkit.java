package com.swforge.toolkit.config;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class ConfigToolkit {
    private String defaultProject;
    private String defaultBranch;
    private String userId;
    private String userPass;
    private String ip;
    private String jUserId;
    private String jUserPass;
    private boolean verbose;
//    testConfig: TTestConfig;
//    jenkinsSetupInfo: TProjectJenkinsSetupInfo;

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
}
