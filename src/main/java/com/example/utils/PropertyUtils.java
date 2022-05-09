package com.example.utils;

import com.example.constants.FrameWorkConstants;
import com.example.enums.ConfigProperties;
import com.example.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {

    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigfilepath())) {
            property.load(file);

            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim())); //removing the trailing and leading spaces

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); //If we want to terminate the program in static block we can use System.exit
        }

    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name : " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
