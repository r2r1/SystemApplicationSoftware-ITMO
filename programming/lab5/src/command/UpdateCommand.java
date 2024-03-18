package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import model.SpaceMarine;
import service.dataProviderService.JSONProvider;

public class UpdateCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public UpdateCommand() throws IOException {}

    JSONProvider json = new JSONProvider("tmp.json");
    ShowCommand showCommand = new ShowCommand();
    @Override
    public void executeFromConsole(String argument) throws IOException {
        System.out.println("> Выполнение команды update из консоли");
        SpaceMarine spaceMarine = collection.updateElementFromConsole(argument);
        collection.update(spaceMarine);
        json.write(SpaceMarineCollection.getSpaceMarines().values());
        System.out.println(
                "> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть обновленную коллекцию");
    }
    @Override
    public void executeFromFile(String argument) throws IOException {
        System.out.println("> Выполнение команды update из файла");
        SpaceMarine spaceMarine = collection.updateElementFromFile(argument);
        collection.update(spaceMarine);
        json.write(SpaceMarineCollection.getSpaceMarines().values());
        System.out.println(
                "> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть обновленную коллекцию");
    }
}
