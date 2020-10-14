package Client;

import This.NewElementData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Scanner;

public class ClientReceiver {
    public  static Socket sock;

    public  static Object receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
        Object obj = objectInputStream.readObject();
        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }

        else if (a == 1){
            System.out.println("\n" +
                    "It is necessary to fill in additional data to execute the command.");
            ClientSender.send(NewElementData.createOrganization());
            obj =receive();
        }

        else if (a == 2){
            System.out.println(obj);
            Scanner reader = new Scanner(System.in);
            String s = reader.nextLine();
            ClientSender.send(s);
            obj =receive();
        }

        return obj;
    }
}