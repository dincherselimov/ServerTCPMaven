package Server;

import Config.Config;
import HTTPServer.HttpServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Negative test for host name
 */
public class HttpServerHostTestNegative {

    @Test
    public void testServerHostNegative() throws IOException {

        HttpServer server212 = new HttpServer(Config.getInstance().getHost(),Config.getInstance().getPort());

        String actual_host = server212.getHost();
        String expected_host = "WROGN HOST";

        assertEquals(expected_host,actual_host);
        System.out.println("Hosts are not equal!");

    }
}