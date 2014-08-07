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

    @Parameter(names = "--ip", description = "External IP address")
    private String ip;

    @Parameter(names = "--juser", description = "Jenkins user ID")
    private String jUser;

    @Parameter(names = "--jpass", description = "Jenkins user password")
    private String jPass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getjUser() {
        return jUser;
    }

    public void setjUser(String jUser) {
        this.jUser = jUser;
    }

    public String getjPass() {
        return jPass;
    }

    public void setjPass(String jPass) {
        this.jPass = jPass;
    }
}
