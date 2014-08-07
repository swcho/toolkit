package com.swforge.toolkit.config;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sungwoo on 14. 8. 7.
 */

public class ConfigUtils {

    static final String KConfigPath = ".toolkit";
    static final String KConfigToolkitName = "toolkit";
    static final String KConfigPathTookit = KConfigPath + File.separator + KConfigToolkitName;

    private static void writeToolkitConfig(final ConfigToolkit configToolkit) throws IOException {
        new File(KConfigPath).mkdirs();
        new File(KConfigPathTookit).delete();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.defaultPrettyPrintingWriter().writeValue(new File(KConfigPathTookit), configToolkit);
    }

    public static void setToolkitConfig(String user, String password, String ip, String jUser, String jPass) throws IOException {
        ConfigToolkit configToolkit = new ConfigToolkit();
        configToolkit.setUserId(user);
        configToolkit.setUserPass(password);
        configToolkit.setIp(ip);
        configToolkit.setJUserId(jUser);
        configToolkit.setJUserPass(jPass);
        writeToolkitConfig(configToolkit);
    }
}
