package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import network.Network;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class GetKeysCommand implements Command {
    SpaceMarineCollection spaceMarineCollection = new SpaceMarineCollection();

    public GetKeysCommand() throws IOException {
    }

    @Override
    public void execute(String argument , DatagramChannel channel) throws IOException {
        Network network = new Network(channel);
        network.send(String.valueOf(spaceMarineCollection.getSpaceMarinesKeys()));
        //return String.valueOf(spaceMarineCollection.getSpaceMarinesKeys());
    }


}
