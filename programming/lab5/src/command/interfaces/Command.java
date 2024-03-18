package command.interfaces;
import java.io.IOException;

public interface Command {
    void executeFromConsole(String argument) throws IOException;
    void executeFromFile( String argument) throws IOException;

}
