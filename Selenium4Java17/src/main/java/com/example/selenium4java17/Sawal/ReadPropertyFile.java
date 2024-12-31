package com.example.selenium4java17.Sawal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) {
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/test.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
        System.out.println(prop.get("username"));

    }
}
