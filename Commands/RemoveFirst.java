package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;
import java.util.NoSuchElementException;

public class RemoveFirst implements Command{
    public  RemoveFirst(){
        CommandExecutor.addCommand("remove_first_element",this);
    }
    public String execute(String arg, OrganizationData data, Socket userSocket, String user) {
           return null;
    }
}
