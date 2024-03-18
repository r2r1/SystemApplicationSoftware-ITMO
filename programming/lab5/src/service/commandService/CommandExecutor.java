package service.commandService;

import command.*;
import command.interfaces.Command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    static Map<String, Command> commandsMap = new HashMap<>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    Command command;
    String argument = "";
    String commandString;
    String[] commandStringSplit;
    String commandParts ;
    String[] commandPartsSplit;
    int  counterCommands;

    /**
     *
     * @param commandParts
     * @param counterCommands
     * @throws FileNotFoundException
     */
    public CommandExecutor(String commandParts, int counterCommands) throws IOException {
        this.commandParts = commandParts;
        this.commandPartsSplit = commandParts.split(" ");
        this.counterCommands = counterCommands;
        try {
            argument = commandPartsSplit[1];
        }catch (Exception ignored){}

        commandsMap.put("help", new HelpCommand());
        commandsMap.put("exit", new ExitCommand());
        commandsMap.put("show", new ShowCommand());
        commandsMap.put("insert", new InsertCommand());
        commandsMap.put("save", new SaveCommand());
        commandsMap.put("info", new InfoCommand());
        commandsMap.put("update", new UpdateCommand());
        commandsMap.put("execute_script", new ExecuteScriptCommand());
        commandsMap.put("clear", new ClearCommand());
        commandsMap.put("remove_key", new RemoveKeyCommand());
        commandsMap.put("history", new HistoryCommand());
        commandsMap.put("max_by_health", new MaxByHealthCommand());
        commandsMap.put("filter_starts_with_name", new FilterStartsWIthNameCommand());
        commandsMap.put("print_field_ascending_weapon_type", new PrintFieldAscendingWeaponTypeCommand());





        this.command = commandsMap.get(commandPartsSplit[0]);
    }



    public static boolean findCommand(String commandScan){
        return commandsMap.get(commandScan) == null;

    }
    public void executeConsoleCommand( ) throws IOException {
        if (command != null) {
            command.executeFromConsole(argument);
        }
        else {
            System.out.println(STR."> \{ANSI_RED}Unknown command: \{commandPartsSplit[0]}\{ANSI_RESET}");
        }
    }
    String arg;
    public void executeFileCommand(String input) throws IOException {

        command = commandsMap.get(input.split(" ")[0]);

        try {
            arg = commandStringSplit[1];
        }catch (Exception _){}

        if (command != null) {
            command.executeFromFile(argument);
        }
        else{
                System.out.println(STR."> \{ANSI_RED}Unknown command: \{input.split(" ")[0]}\{ANSI_RESET}");
            }
        }
    }


