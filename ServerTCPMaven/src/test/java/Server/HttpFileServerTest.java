package Server;

import Config.Config;
import HTTPServer.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Test if the server has started
 * Test if the file has been download
 */
public class HttpFileServerTest {

    //Before everything start the server
    @Before
    public void setServer() throws IOException {
        HttpServer server = new HttpServer(Config.getInstance().getHost(), Config.getInstance().getPort());
        server.serverStart();
    }

    //Stop the server after the test
    @After
    public void tearDown() throws IOException {
        HttpServer server = new HttpServer(Config.getInstance().getHost(), Config.getInstance().getPort());
        server.stop();
    }


    //Testing if the server has started
    @Test
    public void testStart() throws IOException {
        setServer();
        System.out.println("PASSED");
        tearDown();
    }

    @Test
    public void testDownload() throws IOException {
        setServer();

        //URL from HTTP Server
        URL url = new URL("http://localhost:9000/st");
        //Reading the uploaded file
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        //Printing the uploaded file
        in.lines().forEach(System.out::println);
        in.close();

        tearDown();
    }

    @Test
    public void testFileNotFound() throws IOException {
        setServer();

        URL url = new URL("http://localhost:9000/static/not_found");
        url.openStream();

        tearDown();
    }
}