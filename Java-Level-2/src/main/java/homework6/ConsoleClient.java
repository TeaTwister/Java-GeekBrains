package homework6;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConsoleClient extends ConsoleCommunicator {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 8188)) {
            System.out.println("Connected!");
            connect(s);
            System.out.println("Server closed connection.");
            System.exit(0);
        } catch (ConnectException e) {
            System.out.println("Could not find server.");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
