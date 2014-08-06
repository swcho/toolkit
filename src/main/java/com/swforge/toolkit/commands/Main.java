package com.swforge.toolkit.commands;

import com.beust.jcommander.JCommander;

/**
 * Created by sungwoo on 14. 8. 6.
 */
public class Main {

    private JCommander jc;

    public Main(String... args) {
        jc = new JCommander(this);
        jc.addCommand("setup", new CmdSetup());
        jc.parse(args);
        jc.toString();
        jc.usage();
    }

}
