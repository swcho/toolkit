package com.swforge.toolkit;

import com.google.common.base.Optional;
import com.swforge.toolkit.commands.CmdSetup;
import com.swforge.toolkit.commands.ICmdHandler;
import com.swforge.toolkit.config.ConfigToolkit;
import com.swforge.toolkit.config.ConfigUtils;
import com.swforge.toolkit.vcs.IVcs;
import com.swforge.toolkit.vcs.VcsUtils;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public class CommandHandler implements ICmdHandler {

    public CommandHandler() {
    }

    @Override
    public void setup(CmdSetup cmdSetup) throws Exception {
        String id = cmdSetup.getUser();
        String pass = cmdSetup.getPass();
        String ip = cmdSetup.getIp();
        String jUser = Optional.fromNullable(cmdSetup.getjUser()).or(id);
        String jPass = Optional.fromNullable(cmdSetup.getjPass()).or(pass);
        ConfigUtils.setToolkitConfig(id, pass, ip, jUser, jPass);
    }

    @Override
    public void update() throws Exception {
        IVcs vcs = VcsUtils.getVcs(IVcs.TType.ESvn);
        String projectConfigurationUrl = ConfigUtils.getPropProjectConfigurationUrl();
        vcs.syncLocal(projectConfigurationUrl, ConfigUtils.getBaseUrl(), new IVcs.ISyncLocalCallback() {
            @Override
            public void cb(int err, IVcs.TSyncResult syncResult) {
                System.out.format("update cb: err=%d\n", err);
            }
        });
    }
}
