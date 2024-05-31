package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.util.stream.Collectors;

import model.SpaceMarine;
import network.Network;

public class FilterStartsWIthNameCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public FilterStartsWIthNameCommand() throws IOException {}

    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        String result = collection.getSpaceMarinesValues()
                .stream()
                .filter(spaceMarine -> spaceMarine.getName().startsWith(argument))
                .map(SpaceMarine::getName)
                .collect(Collectors.joining("\n"));

        Network network = new Network(channel);
        network.send(result);

        // return result;

    }

}
