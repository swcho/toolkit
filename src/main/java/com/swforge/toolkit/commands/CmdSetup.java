package com.swforge.toolkit.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by sungwoo on 14. 8. 6.
 */
@Parameters(separators = "=", commandDescription = "Setup toolkit")
public class CmdSetup {

    @Parameter(names = "--user", description = "User ID")
    private String user;

    @Parameter(names = "--pass", description = "User password")
    private String pass;

}
