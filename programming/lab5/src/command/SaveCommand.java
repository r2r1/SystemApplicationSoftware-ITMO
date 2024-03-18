package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;

public class SaveCommand implements Command {
    public SaveCommand() {}

    JSONProvider json = new JSONProvider("mainCollection.json");
    @Override
    public void executeFromConsole(String argument) throws IOException {
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }
}
