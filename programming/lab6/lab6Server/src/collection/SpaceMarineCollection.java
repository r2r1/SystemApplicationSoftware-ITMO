package collection;
import model.*;
import network.Network;
import service.PromptScan;
import service.commandService.CommandExecutor;
import service.dataProviderService.JSONProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SpaceMarineCollection {
    public static LinkedHashMap<Long, SpaceMarine> spaceMarines = new LinkedHashMap<>();
    LinkedHashMap<Long, SpaceMarine> sortedSpaceMarines = new LinkedHashMap<>();

    public SpaceMarineCollection() throws IOException {
        sort();
    }
    public void loadCollectionFromJson(String jsonPath) {

        JSONProvider json = new JSONProvider(jsonPath);
        Collection<SpaceMarine> jsonCollection;
        try {
            jsonCollection = json.parse();
            for (SpaceMarine spaceMarine : jsonCollection) {
                spaceMarines.put(spaceMarine.getId(), spaceMarine);
                SpaceMarineCollection.lastId = getSpaceMarinesKeys().size() + 1;
            }
        } catch (IOException ignored){}
    }
    public void sort( ) {

        try {
            List<Map.Entry<Long, SpaceMarine>> entryList = new ArrayList<>(spaceMarines.entrySet());
            entryList.sort(Comparator.comparing(entry -> entry.getValue().getName()));

            for (Map.Entry<Long, SpaceMarine> entry : entryList) {
                sortedSpaceMarines.put(entry.getKey(), entry.getValue());
            }
            spaceMarines = sortedSpaceMarines;

        }catch (Exception ignored){ }
    }
    public static long lastId = 1;

    public void add(SpaceMarine spaceMarine){
        lastId++;
        spaceMarines.put(spaceMarine.getId(), spaceMarine);

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










    public SpaceMarine insertElement(SpaceMarine marine) {
            try {
                // Обработка полученного объекта
                System.out.println("Получен SpaceMarine: " + marine.getName());
                loadCollectionFromJson("tmp.json");
                return marine;
            } catch (NullPointerException e) {
                System.out.println("Клиент некорректно ввел данные");
            }
            return marine;

    }




}

