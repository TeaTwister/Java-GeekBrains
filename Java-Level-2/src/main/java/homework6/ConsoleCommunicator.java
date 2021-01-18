package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleCommunicator {
    protected static void connect(Socket s) throws InterruptedException {
        Thread read = new Thread(new Reader(s));
        read.start();
        Thread write = new Thread(new Writer(s));
        write.start();
        read.join();
    }
}

class Reader implements Runnable {
    Socket s;

    public Reader(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(s.getInputStream())) {
            while (true) {
                String message = in.readUTF();
                System.out.println("Incoming: " + message);
            }
        } catch (IOException e) {
            return;
        }
    }
}

class Writer implements Runnable {
    Socket s;

    public Writer(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try (
                Scanner sc = new Scanner(System.in);
                DataOutputStream out = new DataOutputStream(s.getOutputStream())
        ) {
            while (true) {
                out.writeUTF(sc.nextLine());
            }
        } catch (IOException e) {
            return;
        }
    }
}
