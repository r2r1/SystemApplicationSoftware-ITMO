package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import model.SpaceMarine;

public class FilterStartsWIthNameCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public FilterStartsWIthNameCommand() throws IOException {}

    @Override
    public void executeFromConsole(String argument) throws IOException {
        for (SpaceMarine spaceMarine : collection.getSpaceMarinesValues()) {
            if (spaceMarine.getName().startsWith(argument)) {
                System.out.println(spaceMarine.getName());
            }
        }
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}
