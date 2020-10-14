package Commands;

import This.CommandExecutor;
import This.Organization;
import This.OrganizationData;

import java.net.Socket;

public class UpdateId implements Command {
    public UpdateId() {
        CommandExecutor.addCommand("update_id", this);
    }

    @Override
    public String execute(String s, OrganizationData data, Socket userSocket, String user) {
        return null;
    }
}

