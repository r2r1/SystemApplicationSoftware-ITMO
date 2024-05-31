import collection.SpaceMarineCollection;
import network.Network;
import service.PromptScan;
import service.dataProviderService.JSONProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public   class Server {

    InetSocketAddress address;
    public Server(InetSocketAddress address) {
        this.address  = address;
    }

    public void run() throws IOException, ClassNotFoundException {
        DatagramChannel channel = DatagramChannel.open();
        channel.bind(address);
        System.out.println("Сервер работает!");
        Network network = new Network(channel);



        while (true) {
            System.out.println("Сервер ждет...");
            ByteBuffer buffer = ByteBuffer.allocate(1024  *  6);

            network.receive(buffer);
            String receivedString = new String(buffer.array(), StandardCharsets.UTF_8);
            System.out.println("Сервер получил: " + receivedString.trim());
            String command = new String(buffer.array(), StandardCharsets.UTF_8).trim();


            buffer.clear(); // Очистить буфер перед записью нового ответа
            network.executeCommand(command);





        }
    }
}
