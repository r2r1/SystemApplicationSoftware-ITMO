package command;

import static collection.SpaceMarineCollection.spaceMarines;

import command.interfaces.Command;
import java.io.IOException;
import java.util.*;
import model.SpaceMarine;

public class MaxByHealthCommand implements Command {
    @Override
    public void executeFromConsole(String argument) throws IOException {
        HashMap<Object, Double> health = new HashMap<>();
        for (Map.Entry<Long, SpaceMarine> spaceMarine : spaceMarines.entrySet()) {
            SpaceMarine value = spaceMarine.getValue();
            health.put(value.getName(), value.getHealth());
        }
        Double maxHealth = Collections.max(health.values());

        System.out.println("Максимальное значение health: " + maxHealth);
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}
