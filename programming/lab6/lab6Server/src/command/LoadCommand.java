package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import model.SpaceMarine;
import network.Network;


import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class LoadCommand implements Command {
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
       SpaceMarineCollection collection  = new SpaceMarineCollection();
       collection.loadCollectionFromJson(argument);
        Network network = new Network(channel);
        network.send("Коллекция выгружена из файл в память");
       //return "Коллекция выгружена из файл в память";
    }


}
