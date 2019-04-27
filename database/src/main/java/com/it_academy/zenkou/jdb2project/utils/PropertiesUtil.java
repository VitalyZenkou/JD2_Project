package com.it_academy.zenkou.jdb2project.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PropertiesUtil {

    private static Properties properties;

    static {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Can't find a property file");
        }
    }

    static String get(String key) {
        return properties.getProperty(key);
    }
}
