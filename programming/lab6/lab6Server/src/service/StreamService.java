package service;
import service.commandService.CommandExecutor;
import service.commandService.CommandHistory;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class StreamService {
    String inputStream;

    String command;
    String argument;
    int counterCommands;
    String[] commandOnFile;
    CommandHistory commandHistory = new CommandHistory();
    /**
     * Waiting for the command to execute them
     */

    DatagramChannel channel;
    public StreamService(String inputStream, DatagramChannel channel) {
        this.inputStream = inputStream;
        this.channel = channel;


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
    public void start() throws IOException, ClassNotFoundException {
        CommandExecutor commandService = new CommandExecutor(inputStream, counterCommands);
         commandService.executeConsoleCommand(channel);

    }
}