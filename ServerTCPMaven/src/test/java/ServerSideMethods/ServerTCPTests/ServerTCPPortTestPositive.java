package ServerSideMethods.ServerTCPTests;

import Config.Config;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ServerTCPPortTestPositive {

    /**
     *  This Junit test is testing the port for connection to ClientTCP
     * @int socket_port //Gets the port from config.properties file
     * @asserEquals //Checks if the port is as expected
     * @throws IOException
     */
    @Test
    public void serverTCPP() throws IOException {

        //Getting the port form config.properties
        int socket_port = Config.getInstance().getPort();

        int expected_port = 80;
        //Compares whether the ports are equal or not
        assertEquals(expected_port,socket_port);

        System.out.println("Expected port = " + expected_port + " \n" + "Actual Port = " + socket_port);

    }
}

