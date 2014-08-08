package com.swforge.toolkit.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by sungwoo on 14. 8. 8.
 */
@Parameters(separators = "=", commandDescription = "Set default project and branch")
public class CmdSetDefault {
    @Parameter(names = "--id", description = "Project ID")
    private String id;

    @Parameter(names = "--branch", description = "Project branch")
    private String branch;

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
}
