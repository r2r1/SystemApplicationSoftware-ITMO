package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.util.Collection;
import model.SpaceMarine;
import network.Network;

public class ShowCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public ShowCommand() throws IOException {}
    DatagramChannel channel;
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        this.channel = channel;
        Collection<SpaceMarine> spaceMarines = collection.getSpaceMarinesValues();
        StringBuilder str = new StringBuilder();
        try {
            if (collection.getSize() != 0) {
                for (SpaceMarine spaceMarine : spaceMarines) {
                    str.append("------------------------");
                    str.append("ID: ").append(spaceMarine.getId()).append("\n");
                    str.append("Name: ").append(spaceMarine.getName()).append("\n");
                    str.append("Coordinates: ").append(spaceMarine.getCoordinates().getX()).append(", ").append(spaceMarine.getCoordinates().getY()).append("\n");
                    str.append("Date:  ").append(spaceMarine.getCreationDate()).append("\n");
                    str.append("Health:  ").append(spaceMarine.getHealth()).append("\n");
                    str.append("Loyal:  ").append(spaceMarine.isLoyal()).append("\n");
                    str.append("Category:  ").append(spaceMarine.getCategory()).append("\n");
                    str.append("Weapon:  ").append(spaceMarine.getWeaponType()).append("\n");
                    str.append("Chapter: name:  ").append(spaceMarine.getChapter().getName()).append(" count: ").append(spaceMarine.getChapter().getMarinesCount()).append(" world: ").append(spaceMarine.getChapter().getWorld()).append("\n").append("\n");
                    str.append("------------------------").append("\n");
                }
            } else {
                str.append("Коллекция пуста!");
            }
        } catch (NullPointerException e) {
            str.append(
                    "Элемент, который записался непавильно из-за невалидно ввода даных уже был удален, вызовите show еще раз");
        }

        Network network = new Network(channel);
        network.send(String.valueOf(str));
        //return String.valueOf(str);
    }


}