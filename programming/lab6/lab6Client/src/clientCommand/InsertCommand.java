package clientCommand;

import model.SpaceMarine;
import service.Network;
import service.SpaceMarineAsker;

import java.io.IOException;

public class InsertCommand implements Command {
    SpaceMarineAsker spaceMarineAsker = new SpaceMarineAsker();

    public InsertCommand() throws IOException {
    }

    public void execute(String s) throws IOException, InterruptedException {
        String command = "insert";
        SpaceMarine spaceMarineElement = spaceMarineAsker.getElement(command );

        Network network = new Network();
        network.send(command);
        network.sendObject(spaceMarineElement);

        String receiveMsg = network.receive();
        System.out.println(receiveMsg);
    }
}
