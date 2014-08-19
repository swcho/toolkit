package com.swforge.toolkit.config;

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
