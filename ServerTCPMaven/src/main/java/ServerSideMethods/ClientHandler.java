package ServerSideMethods;

import java.io.*;
import java.net.Socket;
import Config.Config;

/**
 * This class handles multiple client connection using Threads(which implements class Runnable)
 */
public class ClientHandler extends Thread {

    private AcceptFiles fh;
    private SearchInFile sf;
    private final Socket client;
    private String arg;

    /**
     * 1- stands for acceptFileFromClient
     * 2- stands for searchStringInFile
     * @param socket
     * @param arg
     * @throws IOException
     */
    public ClientHandler(Socket socket, String arg) throws IOException {
        this.arg = arg;
        this.client = socket;
        if(arg.equals("1")){
            //accept files from client and save them on this location + file_name
            String location = Config.getInstance().getAbsolute_path();
            this.fh = new AcceptFiles(
                    new BufferedInputStream(client.getInputStream()),
                    new BufferedOutputStream(new FileOutputStream(location + "/dincher.txt")));
        }
        else if(arg.equals("2")){
            this.sf = new SearchInFile(client.getOutputStream(),client.getInputStream());
        }
    }

    /**
     * invoking the serverside methods
     */
    @Override
    public void run() {
        try {
            if(arg.equals("1")){
                this.fh.acceptFileFromClient(fh);
            }
            else if(arg.equals("2")){
                this.sf.searchStringInFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
