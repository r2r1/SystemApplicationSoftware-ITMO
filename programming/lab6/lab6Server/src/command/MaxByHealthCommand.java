package command;

import static collection.SpaceMarineCollection.spaceMarines;

import command.interfaces.Command;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import model.SpaceMarine;
import network.Network;

public class MaxByHealthCommand implements Command {
    DatagramChannel channel;
    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException {
        // Получить максимальное значение здоровья из коллекции spaceMarines с помощью Stream API
        Double maxHealth = spaceMarines.values()
                .stream()
                .mapToDouble(SpaceMarine::getHealth)
                .max()
                .orElse(0.0); // Вернуть 0.0, если коллекция пуста

// Отправить сообщение с максимальным значением здоровья
        Network network = new Network(channel);
        network.send("Максимальное значение health: " + maxHealth);

        //return "";
    }

}
