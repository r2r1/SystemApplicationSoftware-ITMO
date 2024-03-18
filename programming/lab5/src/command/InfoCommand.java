package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;

public class InfoCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();
    String argument;

    public InfoCommand() throws IOException {}

    @Override
    public void executeFromConsole(String argument) throws IOException {
        this.argument = argument;
        System.out.println("Type:" + collection.getClass().getSimpleName());
        System.out.println("Initialization Date: " + collection.getInitializationDate());
        System.out.println("Number of Elements: " + collection.getSize());
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}
