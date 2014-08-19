package com.swforge.toolkit.commands;

/**
 * Created by sungwoo on 14. 8. 7.
 */
public interface ICmdHandler {

    void setup(final CmdSetup cmdSetup) throws Exception;

    void update() throws Exception;

    void setDefault(final CmdSetDefault cmdSetDefault) throws Exception;

    void sync(final CmdSync cmdSync) throws Exception;
}
