package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.util.Collection;
import model.SpaceMarine;

public class ShowCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public ShowCommand() throws IOException {}

    @Override
    public void executeFromConsole(String argument) throws IOException {
        Collection<SpaceMarine> spaceMarines = collection.getSpaceMarinesValues();

        try {
            if (collection.getSize() != 0) {
                for (SpaceMarine spaceMarine : spaceMarines) {
                    System.out.println("------------------------");
                    System.out.println("ID: " + spaceMarine.getId());
                    System.out.println("Name: " + spaceMarine.getName());
                    System.out.println("Coordinates: " + spaceMarine.getCoordinates().getX() + ", " + spaceMarine.getCoordinates().getY());
                    System.out.println("Date:  " + spaceMarine.getCreationDate());
                    System.out.println("Health:  " + spaceMarine.getHealth());
                    System.out.println("Loyal:  " + spaceMarine.isLoyal());
                    System.out.println("Category:  " + spaceMarine.getCategory());
                    System.out.println("Weapon:  " + spaceMarine.getWeaponType());
                    System.out.println("Chapter: name:  " + spaceMarine.getChapter().getName()
                                            + " count: " + spaceMarine.getChapter().getMarinesCount()
                                            + " world: " + spaceMarine.getChapter().getWorld());
                    System.out.println("------------------------");
                }
            } else {
                System.out.println("Коллекция пуста!");
            }
        } catch (NullPointerException e) {
            System.out.println(
                    "Элемент, который записался непавильно из-за невалидно ввода даных уже был удален, вызовите show еще раз");
        }
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}