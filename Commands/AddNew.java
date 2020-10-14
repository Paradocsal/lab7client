package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class AddNew implements Command {
    public AddNew() {
        CommandExecutor.addCommand("add", this);
    }

    public String execute(String s, OrganizationData orgData, Socket userSocket, String user) {
        return null;

    }
}
