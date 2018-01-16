import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties = new Properties();

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

    public static void loadProperties(File file, boolean override) throws Exception {
        loadProperties(new FileInputStream(file), override);
    }

    public static void loadProperties(HashMap<String, Boolean> propertiesFile) throws Exception {
        for(Map.Entry<String, Boolean> entry : propertiesFile.entrySet()){
            loadProperties(new FileInputStream(entry.getKey()), entry.getValue());
        }
    }

    public static void loadPropertiesFromResources(HashMap<String, Boolean> propertiesFile)
            throws Exception {
        for(Map.Entry<String, Boolean> entry : propertiesFile.entrySet()){
            loadProperties(ApplicationProperties.class.getResourceAsStream(entry.getKey()), entry.getValue());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
