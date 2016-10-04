package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import task.Task;

public class ProcessingThread extends Thread {

    private Socket s;
    private ObjectInputStream inputStream;
    private ObjectOutputStream out;

    public ProcessingThread(Socket socket) {
        this.s = socket;
    }

    public void run() {
        try {
            inputStream = new ObjectInputStream(s.getInputStream());
            out = new ObjectOutputStream(s.getOutputStream());
            while (true) {
                System.out.println("Request from client " + s.getPort());
                Task t = (Task) inputStream.readObject();
                t.executeTask();

                out.writeObject(t);
                out.flush();
            }
        } catch (IOException ex) {
            System.out.println("IO Exception @ " + ProcessingThread.class.getName());
            System.out.println("Message :: " + ex.getMessage() + " on port :: " + s.getPort());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception @ " + ProcessingThread.class.getName());
            System.out.println("Message :: " + ex.getMessage() + " on port :: " + s.getPort());
        } finally {
            // Closing streams
            try {
                out.close();
                inputStream.close();
            } catch (IOException ex) {
                System.out.println("Finally while closing streams");
            }
            // Closing streams
        }
    }
}
