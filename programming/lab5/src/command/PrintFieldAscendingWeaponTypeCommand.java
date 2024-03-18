package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import model.SpaceMarine;

public class PrintFieldAscendingWeaponTypeCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public PrintFieldAscendingWeaponTypeCommand() throws IOException {}

    @Override
    public void executeFromConsole(String argument) throws IOException {
        for (SpaceMarine spaceMarine : collection.getSpaceMarinesValues()) {
            System.out.println(spaceMarine.getWeaponType());
        }
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}
