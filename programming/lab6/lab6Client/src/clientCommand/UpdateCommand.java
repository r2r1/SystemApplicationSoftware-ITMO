package clientCommand;

import model.SpaceMarine;
import service.Network;
import service.SpaceMarineAsker;

import java.io.IOException;

public class UpdateCommand implements Command{
    @Override
    public void execute(String arg) throws IOException, InterruptedException {
        SpaceMarineAsker spaceMarineAsker = new SpaceMarineAsker();
        String command = "update";
        SpaceMarine spaceMarineElement = spaceMarineAsker.getElement(command + " " + arg );

        Network network = new Network();
        network.send(command);
        network.sendObject(spaceMarineElement);
        System.out.print("> ");
        System.out.println( network.receive());


            }
}
