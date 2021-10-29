package MAIN;

import Config.Config;
import HTTPServer.HttpServer;
import ServerSideMethods.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RunServers{
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        //Display the menu
        System.out.println("1\t HTTP");
        System.out.println("2\t TCP");

        System.out.println("Please enter your choice:");

        //Get user's choice
        int choice=in.nextInt();

        switch (choice) {
            case 1 -> {
                HttpServer server = new HttpServer(Config.getInstance().getHost(),
                        Config.getInstance().getHTTPPort());
                server.serverStart();
            }
            case 2 -> {
                //waiting for a request on port(for example 93)
                ServerSocket socket = new ServerSocket(Config.getInstance().getPort());
                while (true) {
                    System.out.println("Server Started");
                    //establish connection
                    Socket client = socket.accept();
                    System.out.println("Successful established connection");

                    //use separate threads
                    ClientHandler clientThread = new ClientHandler(client, args[0]);
                    new Thread(clientThread).start();
                }
            }
            default -> System.out.println("Invalid choice");
        }//end of switch
    }
}










































//    private final String arg;
//
//    public RunServers(String arg) {
//        this.arg = arg;
//    }
//
//    public static void main(String[] args) {
//        RunServers runServers = new RunServers(args[0]);
//        new Thread(runServers).start();
//    }
//
//    @Override
//    public void run() {
//        if (arg.equals("2")) {
//            HttpServer server = null;
//            try {
//                server = new HttpServer(Config.getInstance().getHost(),
//                        Config.getInstance().getHTTPPort());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                assert server != null;
//                server.serverStart();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else if (arg.equals("1")) {
//            try {
//                ServerTCP.main(new String[0]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
