package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    static String currentDirectory = System.getProperty("user.dir");
    public String localFilePath = currentDirectory+"/src/application.properties";
    public String jenkinsFilePath = "";
    Properties properties;
    File file;

    public PropertiesReader() {

        properties = new Properties();
        try {
            file = new File(jenkinsFilePath);
            if (file.exists()) {
                properties.load(new FileInputStream(file));

            } else {
                file = new File(localFilePath);
                properties.load(new FileInputStream(file));

            }
        }catch (IOException fne){
            System.out.println("Not able to load file");
        }
        for (String key : properties.stringPropertyNames())
        {
            System.setProperty(key,properties.getProperty(key));
        }
    }
}
