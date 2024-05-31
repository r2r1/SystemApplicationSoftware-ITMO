package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import model.SpaceMarine;
import network.Network;

public class PrintFieldAscendingWeaponTypeCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public PrintFieldAscendingWeaponTypeCommand() throws IOException {}
    DatagramChannel channel;
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        this.channel = channel;
        StringBuilder str = new StringBuilder();
        for (SpaceMarine spaceMarine : collection.getSpaceMarinesValues()) {
            str.append(spaceMarine.getWeaponType());
        }
        Network network = new Network(channel);
        network.send(String.valueOf(str));
        //return String.valueOf(str);
    }


}
