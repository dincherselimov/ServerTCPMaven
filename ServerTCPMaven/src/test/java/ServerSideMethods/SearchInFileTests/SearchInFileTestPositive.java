package ServerSideMethods.SearchInFileTests;

import ServerSideMethods.ClientHandler;
import ServerSideMethods.SearchInFile;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class SearchInFileTestPositive {


    private OutputStream OutputStream;
    private InputStream InputStream;
    private  Socket client;

    BufferedReader input;
    //sending info to the other socket(client)
    PrintWriter out;

    public SearchInFileTestPositive(OutputStream outputStream,InputStream inputStream){
        this.input = new BufferedReader(new InputStreamReader(inputStream));
        this.out = new PrintWriter(outputStream);
    }

    @Test
    public void testSearchInFile1() throws IOException {


        SearchInFile file = new SearchInFile(client.getOutputStream(),client.getInputStream());
        file.searchStringInFile();


    }

}
