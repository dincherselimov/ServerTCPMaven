package Server;

import Config.Config;
import HTTPServer.HttpServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Positive test for host name
 */
public class HttpServerHostTestPositive {

    @Test
    public void testServerHostPositive() throws IOException {

        HttpServer server212 = new HttpServer(Config.getInstance().getHost(),Config.getInstance().getPort());

        String actual_host = server212.getHost();
        String expected_host = "localhost";

        assertEquals(expected_host,actual_host);
        System.out.println("Hosts are equal!");

    }
}
