package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class Clear implements Command {
    public Clear() {
        CommandExecutor.addCommand("clear", this);
    }

    public String execute(String s, OrganizationData org, Socket userSocket, String user) {
    return null;
    }
}
