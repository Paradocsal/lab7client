package Commands;


import This.CommandExecutor;
import This.Organization;
import This.OrganizationData;

import java.net.Socket;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class RemoveGreater implements Command{
    public RemoveGreater() {
        CommandExecutor.addCommand("remove_greater", this);
    }
    public String execute(String arg, OrganizationData data, Socket userSocket, String user) {
       return null;
    }
}
