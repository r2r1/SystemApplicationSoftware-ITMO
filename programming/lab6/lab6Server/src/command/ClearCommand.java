package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import network.Network;
import service.dataProviderService.JSONProvider;
public class ClearCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public ClearCommand() throws IOException {}
    JSONProvider jsonTmp = new JSONProvider("tmp.json");
    JSONProvider jsonMain= new JSONProvider("mainCollection.json");
    @Override
    public  void execute(String argument, DatagramChannel channel) throws IOException {
        collection.clear();
        jsonTmp.clear();
        jsonMain.clear();
        SpaceMarineCollection.lastId = 0;
        Network network = new Network(channel);
        network.send("Коллекция очищена!");
        //return "Коллекция очищена!";
    }
}
