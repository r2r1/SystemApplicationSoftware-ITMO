package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import network.Network;
import service.dataProviderService.JSONProvider;

public class RemoveKeyCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public RemoveKeyCommand() throws IOException {}
    JSONProvider json = new JSONProvider("tmp.json");

    @Override
    public void execute(String id, DatagramChannel channel) throws IOException {
        collection.removeKey(Long.valueOf(id));
        json.write(SpaceMarineCollection.getSpaceMarines().values());
        Network network = new Network(channel);
        network.send("Из коллекции удален элемент с ключом: " + id);
       // return "Из коллекции удален элемент с ключом: " + id;
    }

}
