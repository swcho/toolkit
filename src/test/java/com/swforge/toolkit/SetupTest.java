package com.swforge.toolkit;

import com.swforge.toolkit.commands.CmdUtils;
import org.junit.Test;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class SetupTest {
    @Test
    public void testSetup() {
        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), "setup", "--user", "id", "--pass", "pass");
        cmdUtils.run();
    }

}
