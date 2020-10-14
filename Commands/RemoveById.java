package Commands;


import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class RemoveById implements Command {
    public  RemoveById(){
        CommandExecutor.addCommand("remove_id",this);
    }
    @Override
    public String execute(String arg, OrganizationData data, Socket userSocket, String user) {
       return null;
    }
}
