package com.swforge.toolkit.commands;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public interface ICmdHandler {

    abstract void setup(final CmdSetup cmdSetup) throws Exception;

    abstract void update() throws Exception;
}
