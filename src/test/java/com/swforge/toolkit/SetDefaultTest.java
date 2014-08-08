package com.swforge.toolkit;

import com.swforge.toolkit.commands.CmdUtils;
import org.junit.Test;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public class SetDefaultTest {
    @Test
    public void testSetDefault() {
        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), "set-default", "--id", "hms1000sph2", "--branch", "master");
        cmdUtils.run();
    }
}
