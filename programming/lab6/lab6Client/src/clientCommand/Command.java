package clientCommand;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void execute( String ard) throws IOException, InterruptedException;
}
