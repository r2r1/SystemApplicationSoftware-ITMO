package command.interfaces;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

public interface Command {
    void execute(String argument, DatagramChannel channel) throws IOException, ClassNotFoundException;


}
