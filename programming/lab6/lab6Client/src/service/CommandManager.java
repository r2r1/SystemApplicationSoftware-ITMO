package service;

import clientCommand.Command;
import clientCommand.ExecuteScriptCommand;
import clientCommand.InsertCommand;
import clientCommand.UpdateCommand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    public static Map<String, Command> commandsMap = new HashMap<>();

    public CommandManager() throws IOException {


    }
    static Network network;

    static {
        try {
            network = new Network();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  init() throws IOException {
        commandsMap.put("insert", new InsertCommand());
        commandsMap.put("update", new UpdateCommand());
        commandsMap.put("execute_script", new ExecuteScriptCommand());
    }
    static String argumentString;
    public static  void  executeCommand (String fullCommand) throws IOException, InterruptedException {
        String commandString = fullCommand.split(" ")[0];

        try {
            argumentString = fullCommand.split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException ignored){}


        Command command = commandsMap.get(commandString.trim());
        if (command != null){
            System.out.println("команда " + commandString);
            command.execute(argumentString);

        }
        else {
            System.out.println("send:"+  commandString);
            network.send(commandString);
            System.out.print("> ");
            network.receive();

        }
    }
}
