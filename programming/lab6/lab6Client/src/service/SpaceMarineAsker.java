package service;

import model.*;

import java.io.IOException;
import java.util.*;

import static service.PromptScan.getUserScanner;

public class SpaceMarineAsker {

    String command;
    String arg;
    String response = "";
    Network network = new Network();

    public SpaceMarineAsker() throws IOException {
    }

    public SpaceMarine setElementFromConsole(SpaceMarine element, Date date, String commandSplit) throws IOException {
        Scanner scanner = getUserScanner();
        int counterCommand = 0;
        long id = 0;
        String name = "";
        long x = 0;
        int y = 0;
        boolean loyal = false;
        double health = 0;
        String chapterName = "";
        long spaceMarinesCount = 0;
        String world = "";
        Weapon weaponType = null;
        AstartesCategory category = null;
        this.command = commandSplit.split(" ")[0];
        try {
            this.arg = commandSplit.split(" ")[1];
            System.out.println(arg);
        } catch (Exception ignored){}

        for (int i = 0; i < 1; i++  ) {
            try {

                if (command.equals("update")) {
                    System.out.println("in update");

                    network.send("get_keys");
                    String receiveKeys = network.receive();

                    receiveKeys = receiveKeys.replace("[", " ").replace("]", " ");
                    boolean haveKey = false;
                    String[] keys = receiveKeys.split(",");
                    for (String key : keys) {
                        if (key.trim().equals(arg.trim())) {
                            id = Long.parseLong(arg);
                            haveKey= true ;
                            element.setId(id);
                        }
                    }
                    if (!haveKey) throw new IllegalArgumentException("Ошибка: нет элемента с ключом " + arg);



                }

                if (command.equals("insert")) {
                    System.out.println("in insert");
                    System.out.print("> Введите ID (long): ");
                    do {
                        if (Objects.equals(scanner, System.in)) System.out.print("> Введите ID (long): ");
                        id = Long.parseLong(scanner.nextLine().trim());
                        element.setId(id);
                    } while (!(id > 0));

                }

                do {
                    System.out.println("in name");
                    System.out.print("> Введите имя (String): ");
                    name = scanner.nextLine().trim();
                    System.out.println("name:" +name );
                } while (name.isEmpty());

                counterCommand++;
                boolean isValid;
                do {
                    isValid = true;
                    if (Objects.equals(scanner, System.in)) System.out.print("> Введите coordinates x (float > -194) , y (float > -854) через пробел : ");
                    String coordsXY = scanner.nextLine();
                    String[] coords = coordsXY.split(" ");
                    if (coords.length == 2) {
                        x = Long.parseLong(coords[0]);
                        y = Integer.parseInt(coords[1]);
                    } else isValid = false;


                } while (!((-194 < x) && (-854 < y)) || !isValid);
                counterCommand++;
                String isLoyal;
                do {

                    if (Objects.equals(scanner, System.in)) System.out.print("> Введите loyal (true/false) : ");
                    isLoyal = scanner.nextLine().trim();
                    loyal = Boolean.parseBoolean(isLoyal);
                } while (!(isLoyal.equals("true") || isLoyal.equals("false")));

                counterCommand++;

                do {
                    if (Objects.equals(scanner, System.in)) System.out.print("> Введите health (double > 0): ");
                    health = Double.parseDouble(scanner.nextLine().trim());
                } while (!(health > 0));
                counterCommand++;

                if (Objects.equals(scanner, System.in)) System.out.print("> Введите chapterName (String): ");
                chapterName = scanner.nextLine().trim();
                counterCommand++;

                do {
                    if (Objects.equals(scanner, System.in)) System.out.print("> Введите spaceMarinesCount ( 0 < long < 1000 ) : ");
                    spaceMarinesCount = Long.parseLong(scanner.nextLine().trim());
                } while (!(0 < spaceMarinesCount && spaceMarinesCount < 1000));
                counterCommand++;

                if (Objects.equals(scanner, System.in)) System.out.print("> Введите world (String): ");
                world = scanner.nextLine().trim();
                counterCommand++;

                if (Objects.equals(scanner, System.in)) System.out.print("> Введите weaponType (BOLTGUN/BOLT_RIFLE/PLASMA_GUN/GRENADE_LAUNCHER/INFERNO_PISTOL): ");
                weaponType = Weapon.valueOf(scanner.nextLine().trim());
                counterCommand++;
                if (Objects.equals(scanner, System.in)) System.out.print("> Введите category (AGGRESSOR/INCEPTOR/LIBRARIAN/APOTHECARY): ");
                category = AstartesCategory.valueOf(scanner.nextLine().trim());
                Coordinates coordinates = new Coordinates(x, y);
                Chapter chapter = new Chapter();


                element.setName(name);
                element.setCoordinates(coordinates);
                element.setCreationDate(date);
                element.setLoyal(loyal);
                chapter.setName(chapterName);
                chapter.setWorld(world);
                chapter.setMarinesCount(spaceMarinesCount);
                element.setChapter(chapter);
                element.setWeaponType(weaponType);
                element.setCategory(category);
                element.setHealth(health);
            } catch (IllegalArgumentException e) {
                return null;
                // removeKey(element.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return element;
    }

public SpaceMarine getElement(String command) throws IOException {
    SpaceMarine spaceMarine = new SpaceMarine();
    Date date = new Date();
    return setElementFromConsole(spaceMarine, date, command);
}













    public List<String> getComponents(String command) {

        List<String> components = new ArrayList<>();
        String id = null;
        Scanner scanner = getUserScanner();
        int counterCommand = 0;
        String name = "";
        String x ;
        String y ;
        String loyal ;
        String health;
        String chapterName = "";
        String spaceMarinesCount;
        String world = "";
        String weaponType = null;
        String category = null;
        try {

/*
            if (command.equals("update") ){
                System.out.println("Нет элемента с ключом: " + id);
                throw new IllegalArgumentException("Ошибка: нет элемента с ключом " + id);
            }

            if (command.equals("insert")) {
                do {
                    System.out.print("> Введите ID (long): ");
                    id = scanner.nextLine().trim();
                    element.setId(id);
                }while ( !(id > 0) || getSpaceMarinesKeys().contains(id));
            }
*/

            System.out.print("> Введите ID (long): ");
            id = scanner.nextLine().trim();
            components.add(id);

            System.out.print("> Введите имя (String): ");
            name = scanner.nextLine().trim();
            components.add(name);

            counterCommand++;
            System.out.print("> Введите coordinates x (float > -194) , y (float > -854) через пробел : ");
            String coordsXY = scanner.nextLine();
            components.add(coordsXY);


            counterCommand++;


            System.out.print("> Введите loyal (true/false) : ");
            loyal  = scanner.nextLine().trim();
            components.add(loyal);
            counterCommand++;

            System.out.print("> Введите health (double > 0): ");
            health = scanner.nextLine().trim();
            components.add(health);

            System.out.print("> Введите chapterName (String): ");
            chapterName = scanner.nextLine().trim();
            components.add(chapterName);
            counterCommand++;

            System.out.print("> Введите spaceMarinesCount ( 0 < long < 1000 ) : ");
            spaceMarinesCount = scanner.nextLine().trim();
            components.add(spaceMarinesCount);

            System.out.print("> Введите world (String): ");
            world = scanner.nextLine().trim();
            components.add(world);
            counterCommand++;

            System.out.print("> Введите weaponType (BOLTGUN/BOLT_RIFLE/PLASMA_GUN/GRENADE_LAUNCHER/INFERNO_PISTOL): ");
            weaponType = scanner.nextLine().trim();
            components.add(weaponType);

            counterCommand++;
            System.out.print("> Введите category (AGGRESSOR/INCEPTOR/LIBRARIAN/APOTHECARY): ");
            category = scanner.nextLine().trim();
            components.add(category);


        }  catch (IllegalArgumentException e) {
            System.out.println("> Некорректно введены данные");

        } catch (NullPointerException e) {
            System.out.println("Коллекция пуста! Вы не можете обновить элемент пустой коллекции");
        }
        return components;
    }
}
