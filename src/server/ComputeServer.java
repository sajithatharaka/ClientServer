package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ComputeServer {

    private Socket socket;
    private ServerSocket serverSocket;

    public ComputeServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void init() {
        for(;;){
            try {
                System.out.println("waiting for client ...");
                socket = serverSocket.accept();
                System.out.println("Connected with "+socket.getPort());
                ProcessingThread pt=new ProcessingThread(socket);
                pt.start();
            } catch (IOException ex) {
                System.out.println("IO Exception "+ex.getMessage());
                System.exit(0);
            }
        }
    }
}
