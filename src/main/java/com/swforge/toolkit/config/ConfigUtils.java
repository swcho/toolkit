package com.swforge.toolkit.config;

import com.beust.jcommander.internal.Maps;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by sungwoo on 14. 8. 7.
 */

public class ConfigUtils {

    static final String KConfigPath = ".toolkit";
    static final String KConfigToolkitName = "toolkit";
    static final String KConfigPropertiesName = "config.properties";
    static final String KConfigPathToolkit = KConfigPath + File.separator + KConfigToolkitName;
    static final String KConfigPathProperties = KConfigPath + File.separator + KConfigPropertiesName;
    static String SConfigBase =  ".";

    public static String getBaseUrl() {
        return SConfigBase + File.separator + KConfigPath;
    }

    private static void writeToolkitConfig(final ConfigToolkit configToolkit) throws IOException {
        new File(KConfigPath).mkdirs();
        new File(KConfigPathToolkit).delete();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.defaultPrettyPrintingWriter().writeValue(new File(KConfigPathToolkit), configToolkit);
    }

    public static ConfigToolkit getToolkitConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        ConfigToolkit configToolkit = null;
        try {
            configToolkit= objectMapper.readValue(new File(KConfigPathToolkit), ConfigToolkit.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void setDefaultProject(String id, String branch) throws IOException {
        ConfigToolkit configToolkit = getToolkitConfig();
        configToolkit.setDefaultProject(id);
        configToolkit.setDefaultBranch(branch);
        writeToolkitConfig(configToolkit);
    }

    public static void setSetupJenkinsParam(ConfigProject configProject, String revision, String[] jobTypes) throws IOException {
        ConfigToolkit configToolkit = getToolkitConfig();

        if (configToolkit.getJenkinsSetupInfo() == null) {
            configToolkit.setJenkinsSetupInfo(Maps.<String, Map<String, TSetupJenkinsParam>>newHashMap());
        }

        String projectId = configProject.getId();
        String branch = configProject.getBranch();

        if (!configToolkit.getJenkinsSetupInfo().containsKey(projectId)) {
            configToolkit.getJenkinsSetupInfo().put(projectId, Maps.<String, TSetupJenkinsParam>newHashMap());
        }

        configToolkit.getJenkinsSetupInfo().get(projectId).put(branch, new TSetupJenkinsParam(jobTypes, revision));

        writeToolkitConfig(configToolkit);
    }

    private static String getProp(String key) {
        String ret = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(KConfigPathProperties));
            ret = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getPropProjectConfigurationUrl() {
        return getProp("project_config_url");
    }

    public static String getUserDomain() {
        return getProp("user_domain");
    }

    public static String getFullUserId() {
        String userDomain = ConfigUtils.getUserDomain();
        if (userDomain != null) {
            userDomain = userDomain + "/";
        } else {
            userDomain = "";
        }
        return userDomain + getUserId();
    }

    public static String getUserId() {
        ConfigToolkit configToolkit = ConfigUtils.getToolkitConfig();
        return configToolkit.getUserId();
    }

    public static String getUserPass() {
        ConfigToolkit configToolkit = ConfigUtils.getToolkitConfig();
        return configToolkit.getUserPass();
    }
}
