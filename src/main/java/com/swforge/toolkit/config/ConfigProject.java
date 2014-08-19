package com.swforge.toolkit.config;


public class ConfigProject {

    private String id;
    private String branch;
    private String family;
    private String itsUrl;
    private String downScriptUrl;
    private String tagName;
    private String tagDescription;
    private TVcsConfig[] vcsConfigs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getItsUrl() {
        return itsUrl;
    }

    public void setItsUrl(String itsUrl) {
        this.itsUrl = itsUrl;
    }

    public String getDownScriptUrl() {
        return downScriptUrl;
    }

    public void setDownScriptUrl(String downScriptUrl) {
        this.downScriptUrl = downScriptUrl;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public TVcsConfig[] getVcsConfigs() {
        return vcsConfigs;
    }

    public void setVcsConfigs(TVcsConfig[] vcsConfigs) {
        this.vcsConfigs = vcsConfigs;
    }
}
