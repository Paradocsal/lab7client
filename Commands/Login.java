package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class Login implements Command {
    public  Login(){
        CommandExecutor.addCommand("login",this);
    }
    @Override
    public String execute(String s, OrganizationData data, Socket socket, String user) {

        return null;
    }
}
