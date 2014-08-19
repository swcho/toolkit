package com.swforge.toolkit;

import com.swforge.toolkit.commands.CmdUtils;
import org.junit.Test;

/**
 * Created by sungwoo on 14. 8. 19.
 */
public class UpdateTest {

    @Test
    public void testUpdate() {
        CmdUtils cmdUtils = new CmdUtils(new CommandHandler(), "update");
        cmdUtils.run();
    }

}
