package config;

import common.Constants;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = new FileInputStream(Constants.PATH_TO_CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getProp(String propertyName) {
        if (!StringUtils.isBlank(propertyName)) {
            return properties.getProperty(propertyName);
        } else {
            return StringUtils.EMPTY;
        }
    }

    // ==========
    // general methods
    // ==========

    public static String getBrowserName() {
        return getProp("BROWSER_NAME");
    }

}
