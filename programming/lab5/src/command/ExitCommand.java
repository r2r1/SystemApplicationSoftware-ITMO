package command;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;

public class ExitCommand implements Command {
    JSONProvider jsonProvider = new JSONProvider("tmp.json");
    @Override
    public void executeFromConsole(String argument) throws IOException {
        System.out.println("Exiting...");
        jsonProvider.clear();
        System.exit(0);
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        System.out.println("Exiting...");
        jsonProvider.clear();
        System.exit(0);
    }
}
