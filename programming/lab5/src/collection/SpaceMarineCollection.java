package collection;
import model.*;
import service.PromptScan;
import service.commandService.CommandExecutor;
import service.dataProviderService.JSONProvider;

import java.io.IOException;

import java.util.*;

public class SpaceMarineCollection {
    public  static LinkedHashMap<Long, SpaceMarine> spaceMarines = new LinkedHashMap<>();
    LinkedHashMap<Long, SpaceMarine> sortedSpaceMarines = new LinkedHashMap<>();

    public SpaceMarineCollection() throws IOException {
        sort();
    }
    int counterSRunsCollection = 0;
    public void loadCollectionFromJson(String jsonPath) {
        counterSRunsCollection++;
        JSONProvider json = new JSONProvider(jsonPath);
        Collection<SpaceMarine> jsonCollection;
        try {
            jsonCollection = json.parse();
            for (SpaceMarine spaceMarine : jsonCollection) {
                spaceMarines.put(spaceMarine.getId(), spaceMarine);
                SpaceMarineCollection.lastId = getSpaceMarinesKeys().size() + 1;
            }
        } catch (IOException _){}
    }
    public void sort( ) {

        try {
            List<Map.Entry<Long, SpaceMarine>> entryList = new ArrayList<>(spaceMarines.entrySet());
            entryList.sort(Comparator.comparing(entry -> entry.getValue().getName()));

            for (Map.Entry<Long, SpaceMarine> entry : entryList) {
                sortedSpaceMarines.put(entry.getKey(), entry.getValue());
            }
            spaceMarines = sortedSpaceMarines;

        }catch (Exception _){ }
    }
    public static long lastId = 1;

    public void add(SpaceMarine spaceMarine){
        lastId++;
        spaceMarines.put(spaceMarine.getId(), spaceMarine);

    }
    public void update( SpaceMarine element){
        try {
            spaceMarines.put(element.getId(), element);
        } catch (NullPointerException _){        }

    }
    public void removeKey(Long id){
        spaceMarines.remove(id);
    }
    Date date = new Date();
    public void clear(){
        spaceMarines.clear();
    }
    public java.util.Date getInitializationDate() {
        return date;
    }
    public int getSize(){
        return spaceMarines.size();
    }
    public static LinkedHashMap<Long, SpaceMarine> getSpaceMarines(){
        return spaceMarines;
    }
    public Collection<SpaceMarine> getSpaceMarinesValues() {
        return spaceMarines.values();
    }
    public Set<Long> getSpaceMarinesKeys() {
        return spaceMarines.keySet();
    }
    public SpaceMarine getById(long id) {
        return SpaceMarineCollection.spaceMarines.get(id);
    }

    public SpaceMarine setElementFromFile(long id, SpaceMarine element, Date date, String command) {
        String name ;
        long x = 0;
        int y = 0;
        boolean loyal;
        double health ;
        String chapterName;
        long spaceMarinesCount;
        String world ;
        Weapon weaponType;
        AstartesCategory category ;
        Scanner scanner = PromptScan.getUserScanner();
        int counterCommand = 0;
        try {
            if (command.equals("update") && !getSpaceMarinesKeys().contains(id)) {
                System.out.println("Нет элемента с ключом: " + id);
                throw new IllegalArgumentException();
            }
            counterCommand++;

            name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new  IllegalArgumentException();


            counterCommand++;
            boolean isValid ;
            isValid = true;
            String coordsXY = scanner.nextLine();
            String[] coords = coordsXY.split(" ");
            if (coords.length  == 2){
                x = Long.parseLong(coords[0]);
                y = Integer.parseInt(coords[1]);
            }else isValid = false;
            if (!((-194 < x) && (-854 < y) && isValid)) throw new  IllegalArgumentException()  ;

            counterCommand++;

            String isLoyal;
            isLoyal  = scanner.nextLine().trim();
            loyal = Boolean.parseBoolean(isLoyal);
            if (!(isLoyal.equals("true") ||  isLoyal.equals("false"))) throw new  IllegalArgumentException();


            counterCommand++;

            health = Double.parseDouble(scanner.nextLine().trim());
            if (!(health > 0)) throw new  IllegalArgumentException();

            counterCommand++;

            chapterName = scanner.nextLine().trim();

            counterCommand++;


            spaceMarinesCount = Long.parseLong(scanner.nextLine().trim());
            if ( !(0 < spaceMarinesCount && spaceMarinesCount <  1000)) throw new  IllegalArgumentException();

            counterCommand++;

            world = scanner.nextLine().trim();

            counterCommand++;

            category = AstartesCategory.valueOf(scanner.nextLine().trim());

            counterCommand++;

            weaponType = Weapon.valueOf(scanner.nextLine().trim());
            Coordinates coordinates = new Coordinates(x, y);
            Chapter chapter = new Chapter();

            if(command.equals("insert"))  element.setId(id);
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

            return element;
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректно введены данные, продолжим со следующей известной команды...");
            while (counterCommand < 9){
                String commandScan = scanner.nextLine();
                if (!CommandExecutor.findCommand(commandScan)) counterCommand = 9;
                else counterCommand++;
            };
        } catch (NullPointerException e) {
            System.out.println("Коллекция пуста! Вы не можете обновить элемент пустой коллекции");
        }
        return element;
    }



    public SpaceMarine setElementFromConsole(long id, SpaceMarine element, Date date, String command) {
        Scanner scanner = PromptScan.getUserScanner();
        int counterCommand = 0;
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
        try {
            if (command.equals("update") && !getSpaceMarinesKeys().contains(id)) {
                System.out.println("Нет элемента с ключом: " + id);
                throw new IllegalArgumentException("Ошибка: нет элемента с ключом " + id);
            }

            if (command.equals("insert")) {
                do {
                    System.out.print("> Введите ID (long): ");
                    id = Long.parseLong(scanner.nextLine().trim());
                    element.setId(id);
                }while ( !(id > 0) || getSpaceMarinesKeys().contains(id));
            }

            do{
                System.out.print("> Введите имя (String): ");
                name = scanner.nextLine().trim();
            }while (name.isEmpty());
            counterCommand++;
            boolean isValid ;
            do{
                isValid = true;
                System.out.print("> Введите coordinates x (float > -194) , y (float > -854) через пробел : ");
                String coordsXY = scanner.nextLine();
                String[] coords = coordsXY.split(" ");
                if (coords.length  == 2){
                    x = Long.parseLong(coords[0]);
                    y = Integer.parseInt(coords[1]);
                }else isValid = false;



            }while(!((-194 < x) && (-854 < y)) || !isValid);
            counterCommand++;
            String isLoyal;
            do {

                System.out.print("> Введите loyal (true/false) : ");
                isLoyal  = scanner.nextLine().trim();
                loyal = Boolean.parseBoolean(isLoyal);
            } while (!(isLoyal.equals("true") ||  isLoyal.equals("false")));

            counterCommand++;

            do{
                System.out.print("> Введите health (double > 0): ");
                health = Double.parseDouble(scanner.nextLine().trim());
            }while (!(health > 0));
            counterCommand++;

            System.out.print("> Введите chapterName (String): ");
            chapterName = scanner.nextLine().trim();
            counterCommand++;

            do {
                System.out.print("> Введите spaceMarinesCount ( 0 < long < 1000 ) : ");
                spaceMarinesCount = Long.parseLong(scanner.nextLine().trim());
            }while ( !(0 < spaceMarinesCount && spaceMarinesCount <  1000));
            counterCommand++;

            System.out.print("> Введите world (String): ");
            world = scanner.nextLine().trim();
            counterCommand++;

            System.out.print("> Введите weaponType (BOLTGUN/BOLT_RIFLE/PLASMA_GUN/GRENADE_LAUNCHER/INFERNO_PISTOL): ");
            weaponType = Weapon.valueOf(scanner.nextLine().trim());
            counterCommand++;
            System.out.print("> Введите category (AGGRESSOR/INCEPTOR/LIBRARIAN/APOTHECARY): ");
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
        }  catch (IllegalArgumentException e) {
            System.out.println("> Некорректно введены данные");
            removeKey(element.getId());
        } catch (NullPointerException e) {
            System.out.println("Коллекция пуста! Вы не можете обновить элемент пустой коллекции");
        }
        return element;
    }
    public SpaceMarine insertElementFromConsole(){
        SpaceMarine spaceMarine = new SpaceMarine();
        Date date = new Date();
        long id = 1;
        SpaceMarine element = setElementFromConsole(id, spaceMarine, date, "insert" );
        loadCollectionFromJson("tmp.json");
        return element;
    }
    public SpaceMarine insertElementFromFile()  {
        SpaceMarine spaceMarine = new SpaceMarine();
        long id = SpaceMarineCollection.lastId;
        Date date = new Date();
        SpaceMarine element = setElementFromFile(id, spaceMarine, date, "insert" );
        loadCollectionFromJson("tmp.json");
        return element;
    }
    public SpaceMarine updateElementFromConsole(String argument) {
        long id = Long.parseLong((argument));
        SpaceMarine spaceMarine = new SpaceMarine();
        Date date = new Date();
        SpaceMarine element = setElementFromConsole(id, spaceMarine, date, "update" );
        loadCollectionFromJson("tmp.json");
        return element;

    }
    public SpaceMarine updateElementFromFile(String argument){
        long id = Long.parseLong((argument));
        SpaceMarine spaceMarine = getById(id);
        Date date = new Date();
        SpaceMarine element = setElementFromFile(id, spaceMarine, date, "update");
        loadCollectionFromJson("tmp.json");
        return element;

    }

}

