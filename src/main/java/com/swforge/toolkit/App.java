package com.swforge.toolkit;


import com.swforge.toolkit.commands.CmdUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), args);
        cmdUtils.run();
    }
}
