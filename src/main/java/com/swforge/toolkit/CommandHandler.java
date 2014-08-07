package com.swforge.toolkit;

import com.google.common.base.Optional;
import com.swforge.toolkit.commands.CmdSetup;
import com.swforge.toolkit.commands.ICmdHandler;
import com.swforge.toolkit.config.ConfigUtils;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class CommandHandler implements ICmdHandler {
    @Override
    public void setup(CmdSetup cmdSetup) throws Exception {
        String id = cmdSetup.getUser();
        String pass = cmdSetup.getPass();
        String ip = cmdSetup.getIp();
        String jUser = Optional.fromNullable(cmdSetup.getjUser()).or(id);
        String jPass = Optional.fromNullable(cmdSetup.getjPass()).or(pass);
        ConfigUtils.setToolkitConfig(id, pass, ip, jUser, jPass);
    }
}
