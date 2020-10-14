import Client.ClientReceiver;
import Client.ClientSender;
import Commands.*;
import This.CommandExecutor;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Help helpCommand = new Help();
        Info infoCommand = new Info();
        Exit exitCommand = new Exit();
        Show showCommand = new Show();
        AddNew addNewCommand = new AddNew();
        UpdateId updateCommand = new UpdateId();
        RemoveById removeByIdCommand = new RemoveById();
        Clear clearCommand = new Clear();
        ExecuteScriptFileName executeScriptCommand = new ExecuteScriptFileName();
        Head headCommand = new Head();
        RemoveFirst removeFirstCommand = new RemoveFirst();
        RemoveGreater removeGreaterCommand = new RemoveGreater();
        AverageOfEmployeesCount averageOfEmployeesCountCommand = new AverageOfEmployeesCount();
        PrintFieldDescendingPostalAddress printFieldDescendingPostalAddress = new PrintFieldDescendingPostalAddress();
        FilterStartsWithName filterStartsWithName = new FilterStartsWithName();
        Login login = new Login();
        Register register = new Register();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        ClientSender clientSender = null;
        while(!ClientSender.serverisconnected) {
            try {
                System.out.print("Enter server host\n< ");
                ClientSender.host = in.nextLine();
                System.out.print("Enter server port\n< ");
                int port = Integer.parseInt(in.nextLine());
                ClientSender.port = port;
                ClientSender.tryToConnect();
            } catch (Exception e) {
                System.out.println("Incorrect data...");
            }
        }
            boolean isLogged = false;
        while (true) {
            while (!isLogged){
                try {
                    System.out.println("Enter login to log in | Enter register to register | Access to other commands is restricted.");
                    System.out.print("< ");
                    String s = in.nextLine();
                    if (s.equals(""));
                    else {
                        Map<Command, String> commandparamMap = CommandExecutor.execute(s);
                        if (commandparamMap != null) {
                            if (commandparamMap.entrySet().iterator().next().getKey().getClass().toString().equals("class Commands.Login") || commandparamMap.entrySet().iterator().next().getKey().getClass().toString().equals("class Commands.Register")) {
                                ClientSender.send(commandparamMap);
                                try {
                                    String a = (String) ClientReceiver.receive();
                                    if (a.equals("true")) {
                                        System.out.println("You are successfully logged in.");
                                        isLogged = true;
                                    }else System.out.println(a);
                                } catch (SocketTimeoutException e) {
                                    System.out.println("Server not responding or busy, please try again and make sure the server is running.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else System.out.println("Other commands are prohibited, please log in.");
                    }
                } catch (ClassNotFoundException e) {

                }

            }
            while (ClientSender.serverisconnected) {
                try {
                    System.out.println("Enter the command to send to the server: ");
                    System.out.print("< ");
                    String s = in.nextLine();
                    Map<Command, String> commandparamMap =  CommandExecutor.execute(s);
                    if (commandparamMap != null) {
                        ClientSender.send(commandparamMap);
                        try {
                            System.out.println(ClientReceiver.receive());
                        } catch (SocketTimeoutException e) {
                            System.out.println("Server not responding or busy, please try again and make sure the server is running.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchElementException | ClassNotFoundException e) {
                    System.out.println("The program was interrupted by the user.");
                    System.exit(0);
                }
            }
        }
    }
}
