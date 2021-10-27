package ServerSideMethods.ServerTCPTests;

import Config.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ServerTCPFileNameTestPositive {
    /**
     * This Junit test is testing the path for saving a file from ClientTCP
     * @String actual_filename //Gets the port from config.properties file
     * @asserEquals //Checks if the port is as expected
     */

    @Test
    public void testConfigFileNameP() throws IOException {
        Config config = new Config();

        //Getting the path form config.properties
        String actual_filename = config.getFile_name();

        //Expected path
        String expected_filename = "\\dincher.txt";

        //Compares whether the paths are equal or not
        assertEquals(expected_filename, actual_filename);
        System.out.println("Test passed! \nFile names are equal!");
    }
}
