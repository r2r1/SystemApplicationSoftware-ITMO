package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;
public class ClearCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public ClearCommand() throws IOException {}
    JSONProvider json = new JSONProvider("tmp.json");
    @Override
    public void executeFromConsole(String argument) {
        collection.clear();
        SpaceMarineCollection.lastId = 0;
        System.out.println("Коллекция очищена!");
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }

    @Override
    public void executeFromFile(String argument) {
        collection.clear();
        System.out.println("Коллекция очищена!");
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }
}
