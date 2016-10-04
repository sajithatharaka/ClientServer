package server;

import java.io.IOException;
public class ServerInitializer {
    public static void main(String[] args) throws IOException {
        ComputeServer cs=new ComputeServer(9999);
        cs.init();
    }
}
