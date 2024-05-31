package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import network.Network;
import service.dataProviderService.JSONProvider;

public class SaveCommand implements Command {
    public SaveCommand() {}

    JSONProvider json = new JSONProvider("mainCollection.json");
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        json.write(SpaceMarineCollection.getSpaceMarines().values());
        Network network = new Network(channel);
        network.send("Коллекция загружена в файл");
        //  return "Коллекция загружена в файл";
    }


}
