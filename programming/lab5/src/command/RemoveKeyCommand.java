package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;

public class RemoveKeyCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public RemoveKeyCommand() throws IOException {}
    JSONProvider json = new JSONProvider("tmp.json");

    @Override
    public void executeFromConsole(String id) throws IOException {
        collection.removeKey(Long.valueOf(id));
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }

    @Override
    public void executeFromFile(String id) throws IOException {
        collection.removeKey(Long.valueOf(id));
        json.write(SpaceMarineCollection.getSpaceMarines().values());
    }
}
