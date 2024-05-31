package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.*;
import model.*;
import network.Network;
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
    public  void execute(String argument, DatagramChannel channel) throws IOException, ClassNotFoundException {
        Network network  = new Network(channel);
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // Принятие данных
            channel.receive(buffer);
            buffer.flip();
            // Десериализация объекта
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer.array());
            ObjectInputStream ois = new ObjectInputStream(bais);
            SpaceMarine marine = (SpaceMarine) ois.readObject();

            System.out.println("> Выполнение команды insert из консоли");
            SpaceMarine spaceMarine = collection.insertElement(marine);
            if (spaceMarine.getName() != null) {
                collection.add(spaceMarine);
                jsonProvider.write(collection.getSpaceMarinesValues());
                String receiveString = "Сервер получил элемент SpaceMarine c именем: " + spaceMarine.getName();
                network.send(receiveString.trim());
            } else {
                network.send( "> Space Marine:  null".trim());
            }

        } catch (StreamCorruptedException ignored) {
            // Обработка поврежденного потока данных
            network.send("> Поток данных поврежден".trim());
        } catch (ClassNotFoundException e) {
            // Обработка ошибки, если класс объекта не найден
            network.send("> Класс объекта не найден".trim());
        } catch (IOException e) {
            // Обработка других исключений ввода-вывода
            network.send("> Ошибка ввода-вывода".trim());
        } catch (NullPointerException ignored){
            network.send("Некорректно введены данные!".trim());
        }

    }

}
