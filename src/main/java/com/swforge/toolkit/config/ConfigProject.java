package com.swforge.toolkit.config;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class ConfigProject {

    public enum TVcsType {
        EUnknown,
        ESubversion,
        EGit,
        EMercurial
    }

    public class TVcsConfig {
        private TVcsType vcsType;
        private String repositoryName;
        private String repositoryUrl;
        private String destination;
        private String revision;
        private TVcsConfig[] subConfigs;

        public TVcsType getVcsType() {
            return vcsType;
        }

        public void setVcsType(TVcsType vcsType) {
            this.vcsType = vcsType;
        }

        public String getRepositoryName() {
            return repositoryName;
        }

        public void setRepositoryName(String repositoryName) {
            this.repositoryName = repositoryName;
        }

        public String getRepositoryUrl() {
            return repositoryUrl;
        }

        public void setRepositoryUrl(String repositoryUrl) {
            this.repositoryUrl = repositoryUrl;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getRevision() {
            return revision;
        }

        public void setRevision(String revision) {
            this.revision = revision;
        }

        public TVcsConfig[] getSubConfigs() {
            return subConfigs;
        }

        public void setSubConfigs(TVcsConfig[] subConfigs) {
            this.subConfigs = subConfigs;
        }
    }

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
