package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import network.Network;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class InfoCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();
    String argument;

    public InfoCommand() throws IOException {}

    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        this.argument = argument;
        Network network = new Network(channel);
        String str = "Type:" + collection.getClass().getSimpleName() + "\n" +
        "Initialization Date: " + collection.getInitializationDate() + "\n" +
         "Number of Elements: " + collection.getSize();
        network.send(str);
        //return  "";
    }


}
