package command;
import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import service.dataProviderService.JSONProvider;

public class ExitCommand implements Command {
    JSONProvider jsonProvider = new JSONProvider("tmp.json");
    @Override
        public void execute(String argument, DatagramChannel channel) throws IOException {

        jsonProvider.clear();
        System.exit(0);
        ///return  "Exiting...";
    }

}
