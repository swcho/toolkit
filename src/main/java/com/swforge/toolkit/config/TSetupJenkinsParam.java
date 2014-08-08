package com.swforge.toolkit.config;

/**
 * Created by sungwoo on 14. 8. 8.
 */

public class TSetupJenkinsParam {
    private String[] jobTypes;
    private String revision;

    public TSetupJenkinsParam(String[] jobTypes, String revision) {
        this.jobTypes = jobTypes;
        this.revision = revision;
    }
}
