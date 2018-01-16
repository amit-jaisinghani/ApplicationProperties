import java.util.HashMap;

public class Demo {

    public static void main(String[] args) {
        HashMap<String, Boolean> propertiesFile = new HashMap<>();
        propertiesFile.put("appln.properties", true);
        propertiesFile.put("project.properties", true);
        try {
            ApplicationProperties.loadPropertiesFromResources(propertiesFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("NAME: " + ApplicationProperties.getProperty("NAME"));
        System.out.println("VERSION: " + ApplicationProperties.getProperty("VERSION"));
    }

}
