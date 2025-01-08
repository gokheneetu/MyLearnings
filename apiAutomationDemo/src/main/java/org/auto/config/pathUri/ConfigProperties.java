package org.auto.config.pathUri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    public static Properties prop;
    public ConfigProperties(){
        try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/path.properties");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProp(String key){
        if(key !=null){
            return prop.getProperty(key);
        }else return null;
    }
}
