package command;

import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.util.List;

import network.Network;
import service.commandService.CommandHistory;

public class HistoryCommand implements Command {
    List<String> commandList = CommandHistory.getCommandList();
    int finishIdx = Math.max(0, commandList.size() - 5);
    DatagramChannel channel;
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        Network network = new Network(channel);
        this.channel = channel;
        StringBuilder str = new StringBuilder();
        for (int i = commandList.size() - 1; i >= finishIdx; i--) {
            str.append(commandList.get(i)).append(" ").append(i).append("\n");

        }
        network.send(String.valueOf(str));
        //return String.valueOf(str);
    }


}
