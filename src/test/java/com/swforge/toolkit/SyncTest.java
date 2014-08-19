package com.swforge.toolkit;

import com.swforge.toolkit.commands.CmdUtils;
import org.junit.Test;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public class SyncTest {

    @Test
    public void testSync() {
        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), "sync");
        cmdUtils.run();
    }

}
