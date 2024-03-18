package command;

import command.interfaces.Command;
import java.io.IOException;
import java.util.List;
import service.commandService.CommandHistory;

public class HistoryCommand implements Command {
    List<String> commandList = CommandHistory.getCommandList();
    int finishIdx = Math.max(0, commandList.size() - 5);

    @Override
    public void executeFromConsole(String argument) throws IOException {
        for (int i = commandList.size() - 1; i >= finishIdx; i--) {
            System.out.println(commandList.get(i) + " " + i);
        }
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}
