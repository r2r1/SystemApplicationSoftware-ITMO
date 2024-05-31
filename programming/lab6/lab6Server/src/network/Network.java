package network;

import service.StreamService;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Network {
    static SocketAddress clientAddress ;
   static DatagramChannel channel;

    public Network( DatagramChannel channel) {
        Network.channel = channel;
    }
    public void executeCommand(String command) throws IOException, ClassNotFoundException {
        StreamService streamService = new StreamService(command, channel);
        streamService.start();
    }

    public void send( String message) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
        channel.send(buffer, clientAddress);
        System.out.println("Овет отправлен");
    }

    public String receive(ByteBuffer buffer) throws IOException {
        clientAddress =  channel.receive(buffer);
        String receivedString = new String(buffer.array(), StandardCharsets.UTF_8).trim();

        buffer.clear();
        return  receivedString;
    }



}
