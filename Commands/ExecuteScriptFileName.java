package Commands;

import This.CommandExecutor;
import This.OrganizationData;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScriptFileName implements Command {
    public ExecuteScriptFileName() {
        CommandExecutor.addCommand("execute_script", this);
    }
    static ArrayList<String> exScrHistory = new ArrayList<>();
    @Override
    public String execute(String s, OrganizationData data, Socket userSocket, String user) {
      return null;
    }
}
