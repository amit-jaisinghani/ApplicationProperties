package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The {@code {@link ApplicationProperties}} provides a simple way to load all properties required by
 * a java project.
 *
 * @author     : Amit Jaisinghani
 *
 */
public class ApplicationProperties {

    //Holds loaded properties
    private static Properties properties = new Properties();

    /**
     * Load properties from an InputStream and provides an option to restriction on overriding property.
     *
     * @param file InputStream of file containing properties to load
     * @param override Restriction on overriding property
     * @throws Exception if override is false and duplicate property is found, an exception is raised.
     */
    public static void loadProperties(InputStream file, boolean override) throws Exception {
        Properties temporaryProperties = new Properties();
        temporaryProperties.load(file);
        for(Object property : temporaryProperties.keySet()){
            if(properties.containsKey(property)){
                if(override) {
                    System.out.println("Duplicate property found :: " + property);
                } else {
                    throw new Exception("Duplicate property not allowed. Property :: " + property);
                }
            } else {
                System.out.println("Property loaded :: " + property);
            }
        }
        properties.putAll(temporaryProperties);
    }

    /**
     * Load properties from a File and provides an option to restriction on overriding property.
     *
     * @param file File containing properties to load
     * @param override Restriction on overriding property
     * @throws Exception if override is false and duplicate property is found, an exception is raised.
     */
    public static void loadProperties(File file, boolean override) throws Exception {
        loadProperties(new FileInputStream(file), override);
    }

    /**
     * Load properties from all files listed in propertiesFile.
     *
     * @param propertiesFile Contains map of file name containing properties to override option.
     * @throws Exception if override is false and duplicate property is found, an exception is raised.
     */
    public static void loadProperties(HashMap<String, Boolean> propertiesFile) throws Exception {
        for(Map.Entry<String, Boolean> entry : propertiesFile.entrySet()){
            loadProperties(new FileInputStream(entry.getKey()), entry.getValue());
        }
    }

    /**
     * Load properties from all files listed in propertiesFile and located in resources folder.
     *
     * @param propertiesFile Contains map of file name containing properties to override option.
     * @throws Exception if override is false and duplicate property is found, an exception is raised.
     */
    public static void loadPropertiesFromResources(HashMap<String, Boolean> propertiesFile)
            throws Exception {
        for(Map.Entry<String, Boolean> entry : propertiesFile.entrySet()){
            loadProperties(ApplicationProperties.class.getResourceAsStream(entry.getKey()), entry.getValue());
        }
    }

    /**
     * Fetch a loaded property using key.
     *
     * @param key - Property name
     * @return property associated with required property name.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
