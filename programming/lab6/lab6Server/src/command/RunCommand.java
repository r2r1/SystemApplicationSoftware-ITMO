package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import network.Network;
import service.PromptScan;
import service.dataProviderService.JSONProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RunCommand implements Command {
    SpaceMarineCollection collection = new SpaceMarineCollection();

    public RunCommand() throws IOException {
    }

    @Override
    public void execute(String argument, DatagramChannel channel) throws IOException, ClassNotFoundException {
        System.out.println("К серверу подключился клиент: " + channel.getLocalAddress().toString());
        Scanner consoleScanner = PromptScan.getUserScanner();
        SpaceMarineCollection spaceMarineCollection = new SpaceMarineCollection();
        Network network = new Network(channel);
        spaceMarineCollection.loadCollectionFromJson("mainCollection.json");
        JSONProvider jsonProvider = new JSONProvider("tmp.json");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tmp.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonContent = stringBuilder.toString();
            if ((!(jsonContent.contains("{}") || jsonContent.contains("[]")))) {
                ByteBuffer bufferAns = ByteBuffer.allocate(1024 * 6);

                network.send("> Вы подключились к серверу \n> Прошлый запуск программы был звершен досрочно, хотите ли вы вернуть коллекцию? \n> (y/n) : ");
                String answer = network.receive(bufferAns);

                if (answer.equals("y")) {
                    spaceMarineCollection.loadCollectionFromJson("tmp.json");
                    network.send("> Коллекция возобновлена!");
                } else {
                    jsonProvider.clear();
                    // collection.clear(); // удаление из памяти коллекции, создаваемую в реальном времени другими клиентами
                    network.send("> Коллекция c прошлого запуска удалена!");
                }

            }
            else {
                network.send("> Вы подключились к серверу");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
