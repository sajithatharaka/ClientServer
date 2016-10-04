package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import task.CalculateGCD;
import task.CalculatePi;
import task.CalculatePrimes;
import task.Task;

public class ComputeClient {

    private Socket socket;
    private Task t;
    private ObjectOutputStream out;

    public ComputeClient(String serverName, int port, Task t) throws IOException {
        this.t = t;
        this.socket = new Socket(serverName, port);
        System.out.println("Just connected to " + socket.getRemoteSocketAddress());
    }

    public void init() throws IOException {
        // Creating ObjectOutPutStream to send data to the server
        OutputStream outToServer = socket.getOutputStream();
        out = new ObjectOutputStream(outToServer);

        // Creating ObjectInputStream to recieve data from the server
        InputStream inFromServer = socket.getInputStream();
        ObjectInputStream in = new ObjectInputStream(inFromServer);
        try {
            while (true) {
                Scanner readData = new Scanner(System.in);
                System.out.println("**************************************");
                System.out.println("Calculate Pi ------------------------1");
                System.out.println("Calculate Primes --------------------2");
                System.out.println("Calculate Greates Commmon Divisor ---3");
                System.out.println("**************************************");

                // Selecting the compute-task 
                System.out.print("Enter your option: ");
                String option = readData.nextLine();

                switch (option) {
                    case "1":
                        System.out.println("Enter the number of digits after the decimal point of Pi: ");
                        t = new CalculatePi(Integer.parseInt(readData.nextLine()));
                        break;
                    case "2":
                        System.out.println("Enter the number till which the prime numbers are to be calculated: ");
                        t = new CalculatePrimes(Integer.parseInt(readData.nextLine()));
                        break;
                    case "3":
                        System.out.println("Enter first integer: ");
                        String first = readData.nextLine();
                        System.out.println("Enter second integer: ");
                        String second = readData.nextLine();
                        t = new CalculateGCD(Integer.parseInt(first), Integer.parseInt(second));
                        break;
                    default:
                        System.exit(0);
                }
                // Serializing the Object
                out.writeObject(t);
                out.flush();

                // Deserializing the Object and get the compute-value
                Task t = (Task) in.readObject();
                System.out.println(t.getResult());
                System.out.println(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
