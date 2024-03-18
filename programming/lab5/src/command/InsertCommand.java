package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import java.util.*;
import model.*;
import service.dataProviderService.JSONProvider;

public class InsertCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";
    Map<String, Enum> weapons = new HashMap<>();
    Map<String, Enum> astartesCategorys = new HashMap<>();
    public InsertCommand() throws IOException {
        weapons.put("BOLTGUN", Weapon.BOLTGUN);
        weapons.put("BOLT_RIFLE", Weapon.BOLT_RIFLE);
        weapons.put("PLASMA_GUN", Weapon.PLASMA_GUN);
        weapons.put("GRENADE_LAUNCHER", Weapon.GRENADE_LAUNCHER);
        weapons.put("INFERNO_PISTOL", Weapon.INFERNO_PISTOL);

        astartesCategorys.put("AGGRESSOR", AstartesCategory.AGGRESSOR);
        astartesCategorys.put("INCEPTOR", AstartesCategory.INCEPTOR);
        astartesCategorys.put("LIBRARIAN", AstartesCategory.LIBRARIAN);
        astartesCategorys.put("APOTHECARY", AstartesCategory.APOTHECARY);
    }

    JSONProvider jsonProvider = new JSONProvider("tmp.json");

    @Override
    public void executeFromConsole(String argument) throws IOException {
        System.out.println("> Выполнение команды insert из консоли");
        SpaceMarine spaceMarine = collection.insertElementFromConsole();
        if (spaceMarine.getName() != null)
            collection.add(spaceMarine);
        jsonProvider.write(collection.getSpaceMarinesValues());
        System.out.println("> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть коллекцию");
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        System.out.println("> Выполнение команды insert из файла");
        SpaceMarine spaceMarine = collection.insertElementFromFile();
        if (spaceMarine.getName() != null)
            collection.add(spaceMarine);
        jsonProvider.write(collection.getSpaceMarinesValues());
        System.out.println("> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть коллекцию");
    }
}
