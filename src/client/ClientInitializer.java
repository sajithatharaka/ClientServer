package client;

import java.io.IOException;
import task.Task;

public class ClientInitializer {

    static Task t;

    public static void main(String[] args) throws IOException {
        new ComputeClient("localhost", 9999, t).init();
    }

}
