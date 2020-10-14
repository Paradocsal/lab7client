package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class Register implements Command{
    public  Register(){
        CommandExecutor.addCommand("register",this);
    }
    @Override
    public String execute(String s, OrganizationData data, Socket socket, String user) {
        return null;
    }
}
