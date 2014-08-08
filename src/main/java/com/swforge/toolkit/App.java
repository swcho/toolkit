package com.swforge.toolkit;


import com.swforge.toolkit.commands.CmdUtils;
import org.tmatesoft.svn.cli.SVN;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), args);
//        cmdUtils.run();
        SVN.main(args);
    }
}
