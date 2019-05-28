package com.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ActionWrapper {
    Logger logger = Logger.getLogger(ActionWrapper.class);

    public String readProprtyFile(String key) {
        try (InputStream input = ActionWrapper.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                throw new FileNotFoundException();
            }
            //load a properties file from class path, inside static method
            prop.load(input);
            //get the property value and print it out
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }


}