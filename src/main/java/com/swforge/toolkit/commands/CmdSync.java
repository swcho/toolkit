package com.swforge.toolkit.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by sungwoo on 14. 8. 19.
 */
@Parameters(separators = "=", commandDescription = "Sync project source code")
public class CmdSync {

    @Parameter(names = "--tag-name", description = "Sync with specific tag name.")
    private String user;

}
