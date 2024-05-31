package service;

import model.SpaceMarine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Network {


    static String host = "127.0.0.1";
    static int port = 5000;
    DatagramChannel channel = DatagramChannel.open();

    InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(host), port);


    public Network() throws IOException {

    }


    public DatagramChannel getChannel(){
        return  channel;
    }

    public void send(String message) throws IOException, InterruptedException {
        DatagramChannel.open();

        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(data);

        channel.send(buffer, inetSocketAddress);
        buffer.clear(); // Очистить буфер перед чтением ответа


    }

    public void sendObject(SpaceMarine spaceMarine) throws IOException {
        DatagramSocket socket = channel.socket();
        socket.setSoTimeout(5000);

        DatagramChannel.open();
        // Сериализуем объект в байтовый массив
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(spaceMarine);
        oos.flush();
        byte[] bytes = baos.toByteArray();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        channel.send(buffer, inetSocketAddress);

    }




    public String receive() throws IOException {
        ByteBuffer responseBuffer = ByteBuffer.allocate(1024 * 6);
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_READ);
        boolean haveReceive = false;


        try {
            while (true) {
                // Ждем события на каналах
                int readyChannels = selector.select(1000); // Таймаут 1 секунда

                if (readyChannels == 0) {
                    System.out.println("Сервер не ответил, повторите еще раз, ! ");
                    return null;
                }

                // Получаем ключи событий
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isReadable()) {
                        // Канал готов для чтения данных
                        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
                        SocketAddress fromAddress = channel.receive(receiveBuffer);

                        if (fromAddress != null) {
                            receiveBuffer.flip();
                            byte[] data = new byte[receiveBuffer.remaining()];
                            receiveBuffer.get(data);
                            String receivedMessage = new String(data);
                            System.out.println("> Получено сообщение от сервера: \n" + receivedMessage);
                            keyIterator.remove();
                            return receivedMessage; // Завершаем после получения ответа
                        }
                    }
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    // Планируем выполнение задачи через 10 секунд





}
