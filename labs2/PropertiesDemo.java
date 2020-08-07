package java112.labs2;


import java.io.*;
import java.util.*;


/**
 * @author Eric Knapp
 * class name
 */
public class PropertiesDemo {

    private Properties properties;
    
    /**
     * Run the demo
     */
    public void run() {
        loadProperties("/example.properties");
        
        System.out.println("author: " + properties.getProperty("author"));
        System.out.println("email: " + properties.getProperty("email"));
    }


    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        PropertiesDemo demo = new PropertiesDemo();
        demo.run();
    }
}