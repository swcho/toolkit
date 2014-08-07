package com.swforge.toolkit.config;

import com.beust.jcommander.internal.Maps;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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

    public static ConfigToolkit getToolkitConfig() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ConfigToolkit configToolkit = objectMapper.readValue(new File(KConfigPathTookit), ConfigToolkit.class);
        return configToolkit;
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

    public static void setSetupJenkinsParam(ConfigProject configProject, String revision, String[] jobTypes) throws IOException {
        ConfigToolkit configToolkit = getToolkitConfig();

        if (configToolkit.getJenkinsSetupInfo() == null) {
            configToolkit.setJenkinsSetupInfo(Maps.<String, Map<String, ConfigToolkit.TSetupJenkinsParam>>newHashMap());
        }

        String projectId = configProject.getId();
        String branch = configProject.getBranch();

        if (!configToolkit.getJenkinsSetupInfo().containsKey(projectId)) {
            configToolkit.getJenkinsSetupInfo().put(projectId, Maps.<String, ConfigToolkit.TSetupJenkinsParam>newHashMap());
        }

        configToolkit.getJenkinsSetupInfo().get(projectId).put(branch, configToolkit.new TSetupJenkinsParam(jobTypes, revision));

        writeToolkitConfig(configToolkit);
    }


}
