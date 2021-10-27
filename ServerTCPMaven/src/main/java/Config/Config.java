package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class uses Singleton method and has a connection to config.properties file
 */
public class Config {

    private final int TCPPort;
    private final String absolute_path;
    private final String file_name;
    private static Config instance = null;
    private final int HTTPPort;
    private final String host;

    //Define the config.properties file path
    FileInputStream FIS;
    {
        try {
            FIS = new FileInputStream("D:\\Manik\\ServerTCPMaven\\ServerTCPMaven\\src\\main\\java\\ConfigFiles\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Properties properties;

    //Loading the config.properties file
    public Config() throws IOException {
        properties = new Properties();
        properties.load(FIS);
        FIS.close();
        //reading the element's content from config.properties
        TCPPort = Integer.parseInt(properties.getProperty("TCPPort"));
        absolute_path = properties.getProperty("absolute_path");
        file_name = properties.getProperty("file_name");
        HTTPPort = Integer.parseInt(properties.getProperty("HTTPPort"));
        host = properties.getProperty("host");
    }
    //Using Singleton method
    public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    //---------------------------------------------------------------------//
    //Getters
    public int getPort(){return this.TCPPort;}

    public String getAbsolute_path(){return this.absolute_path;}

    public String getFile_name(){return this.file_name;}

    public int getHTTPPort() {
        return HTTPPort;
    }

    public String getHost() {
        return host;
    }
}

