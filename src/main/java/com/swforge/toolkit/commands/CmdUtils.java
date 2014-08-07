package com.swforge.toolkit.commands;

import com.beust.jcommander.JCommander;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by sungwoo on 14. 8. 6.
 */
public class CmdUtils {

    private JCommander jc;
    private Map<String, TCommandInfo> handlerMap;

    private interface ICallback {
        void handleCommand(Object obj) throws Exception ;
    }

    private class TCommandInfo {
        private Object obj;
        private ICallback callback;

        public TCommandInfo(Object obj, ICallback callback) {
            this.obj = obj;
            this.callback = callback;
        }
    }

    public CmdUtils(final ICmdHandler cmdHandler, String... args) {
        handlerMap = Maps.newHashMap();
        jc = new JCommander(this);

        addCommand("setup", new CmdSetup(), new ICallback() {
            @Override
            public void handleCommand(Object obj) throws Exception {
                CmdSetup setup = CmdSetup.class.cast(obj);
                cmdHandler.setup(setup);
            }
        });

        jc.parse(args);
    }

    public void run() {
        String parsedCommand = jc.getParsedCommand();
        if (!Strings.isNullOrEmpty(parsedCommand)) {
            System.out.println("getParsedCommand: " + jc.getParsedCommand());
            TCommandInfo info = handlerMap.get(parsedCommand);
            try {
                info.callback.handleCommand(info.obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            jc.usage();
        }
    }

    private void addCommand(String command, Object obj, ICallback callback) {
        jc.addCommand(command, obj);
        handlerMap.put(command, new TCommandInfo(obj, callback));
    }
}
