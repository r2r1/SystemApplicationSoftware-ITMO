package service;
import service.commandService.CommandExecutor;
import service.commandService.CommandHistory;

import java.io.FileNotFoundException;
import java.io.IOException;
public class StreamService {
    String inputStream;
    Boolean consoleInput;
    String command;
    String argument;
    int counterCommands;
    String[] commandOnFile;
    CommandHistory commandHistory = new CommandHistory();
    /**
     * Waiting for the command to execute them
     */
    public StreamService(String inputStream, Boolean consoleInput) {
        this.inputStream = inputStream;
        this.consoleInput = consoleInput;


        command = inputStream.split(" ")[0];
        try {
            argument = inputStream.split(" ")[1];
        }catch (Exception ignored){};
        commandHistory.addCommand(command);
    }

    /**
     *
     *
     */
    public void start() throws IOException {
        CommandExecutor commandService = new CommandExecutor(inputStream, counterCommands);
        if (consoleInput){
            commandService.executeConsoleCommand();
        }
        else {
            commandService.executeFileCommand(inputStream);
        }
    }
}