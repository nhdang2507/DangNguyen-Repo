package com.nashtech.finalcucumber.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
public class PropertiesFileUtil {
    private static Properties properties;
    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileUtil.class);

    private PropertiesFileUtil() {
    }

    public static void readProperties(String filePath) throws IOException {
        LOGGER.info("Load Properties file {} at thread {} ", filePath, Thread.currentThread().getId());
        try (InputStream input = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeProperties(String filePath, String propertyName, String propertyValue) throws IOException {
        LOGGER.info("Write properties file {} at thread {} ", filePath, Thread.currentThread().getId());
        OutputStream output = new FileOutputStream(filePath);
        properties.setProperty(propertyName, propertyValue);
        properties.store(output, null);

    }

    public static String getProperty(String propertyKey) {
        if (properties == null) {
            LOGGER.error("Can not get properties {} in Properties File at thread {}", propertyKey, Thread.currentThread().getId());
        }
        LOGGER.info("get properties {} at thread {}", propertyKey, Thread.currentThread().getId());
        return properties.getProperty(propertyKey);
    }

    public static void setProperty(String propertyKey, String propertiesName) {
        if (properties == null) {
            LOGGER.error("Can not set properties {} in Properties File at thread {}", propertyKey, Thread.currentThread().getId());
        }
        LOGGER.info("set properties {} with value {} at thread {}", propertyKey, propertiesName, Thread.currentThread().getId());
        properties.setProperty(propertyKey, propertiesName);
    }
}
