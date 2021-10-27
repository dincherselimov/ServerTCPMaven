package ServerSideMethods.ServerTCPTests;

import Config.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;

public class ServerTCPFileNameTestNegative {

    /**
     * This Junit test is testing the path for saving a file from ClientTCP
     * @String actual_path //Gets the port from config.properties file
     * @String expected_path //Expected path
     * @asserEquals //Checks if the port is as expected
     */

    @Test

    public void testConfigFileNameN() throws IOException {
        Config config = new Config();

        //Getting the path form config.properties
        String actual_filename = config.getAbsolute_path();

        //Expected path
        String expected_filename = "\\dincher.txt";

        //Compares whether the paths are equal or not
        assertNotEquals(expected_filename, actual_filename);
        System.out.println("Test passed! \nFile names are not equal!");
    }
}