package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSender {
    public static Boolean serverisconnected = false;
    public static int port;
    public static String host;

    public static void send(Object o) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ClientReceiver.sock.getOutputStream());
            objectOutputStream.writeObject(o);

        } catch (IOException e) {
            System.out.println("Some error has occurred,reconnecting...");
            ClientSender.serverisconnected = false;
        }
    }

    public static void tryToConnect() {

        try {
            Socket socket = new Socket(host, port);
            serverisconnected = true;
            System.out.println("Successfully connected to the server.");
            ClientReceiver.sock = socket;

        } catch (IOException e) {
            System.out.println("Seems like the server is down or unavailable, please try again later.");
        }
    }
}
