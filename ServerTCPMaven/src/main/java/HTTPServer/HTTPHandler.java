package HTTPServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * HTTP Handler class for handling incoming request(GET, PUT)
 */
public class HTTPHandler implements HttpHandler {

    /**
     *  Handling GET,PUT,POST,DELETE,HEAD requests from client
     * @param httpExchange
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String req_method = httpExchange.getRequestMethod().trim();

        String response = null;

        if ("PUT".equalsIgnoreCase(req_method)) {
            response = handlePutRequest(httpExchange);

        } else if ("GET".equalsIgnoreCase(req_method)) {
            System.out.println("GET");
            response = handleGetRequest(httpExchange);
        }
        System.out.println("response");

        assert response != null;
        handleResponse(httpExchange,  response);
    }

    /**
     * Handler for GETRequest
     * Reading the data from specific file
     * @param httpExchange
     * @return
     * @throws IOException
     */
    private String handleGetRequest(HttpExchange httpExchange) throws IOException {

        File file = new File("D:\\Manik\\ServerTCPMaven\\ServerTCPMaven\\src\\main\\java\\SavedFiles\\test1.xml");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        return new String(data, StandardCharsets.UTF_8);
    }

    /**
     * Handler for PUTRequest
     * Read the request body and save it to a file
     * If the file already exists then update the content of the existing file
     * @param httpExchange
     * @return
     * @throws IOException
     */
    public String handlePutRequest(HttpExchange httpExchange) throws IOException {

        //Get the incoming data(request body)
        InputStream bodyStream = httpExchange.getRequestBody();

        //reading all remaining byte from the input stream
        byte []b = bodyStream.readAllBytes();
        String toWrite = new String(b);

        try {
            //Save the incoming data to a file
            FileWriter putWriter = new FileWriter("D:\\Manik\\ServerTCPMaven\\ServerTCPMaven\\src\\main\\java\\SavedFiles\\test1.xml");
            putWriter.write(toWrite);

            //close the connection
            putWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return httpExchange.getRequestMethod();
    }

    private void handleResponse (HttpExchange httpExchange, String response)  throws IOException {

        OutputStream outputStream = httpExchange.getResponseBody();

        // Send response code 200 and read the length of html response
        httpExchange.sendResponseHeaders(200, response.length());

        //write the data
        outputStream.write(response.getBytes());
        outputStream.flush();

        //close the stream
        outputStream.close();

    }
}
