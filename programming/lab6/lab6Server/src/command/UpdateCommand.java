package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import model.SpaceMarine;
import network.Network;
import service.dataProviderService.JSONProvider;

public class UpdateCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public UpdateCommand() throws IOException {}

    JSONProvider jsonProvider = new JSONProvider("tmp.json");

    ShowCommand showCommand = new ShowCommand();
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
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

            System.out.println("> Выполнение команды update из консоли");
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
        } catch (NullPointerException e){
            network.send("Некорректно введены данные!".trim());
        }

    }

}
