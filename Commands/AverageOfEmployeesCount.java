package Commands;


import This.CommandExecutor;
import This.OrganizationData;

import java.net.Socket;

public class AverageOfEmployeesCount implements Command{
    public AverageOfEmployeesCount() {
        CommandExecutor.addCommand("Average_of_employees_count", this);
    }

    @Override
    public String execute(String arg, OrganizationData data, Socket userSocket, String user) {
     return null;
    }
}
