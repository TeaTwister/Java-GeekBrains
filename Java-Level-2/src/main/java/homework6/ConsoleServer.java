package homework6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleServer extends ConsoleCommunicator {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(8188)) {
            System.out.println("Awaiting connection...");
            Socket s = ss.accept();
            System.out.println("Connected!");
            connect(s);
            System.out.println("Client closed connection.");
            System.exit(0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
