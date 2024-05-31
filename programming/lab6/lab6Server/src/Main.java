import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {

    Server server = new Server(new InetSocketAddress(5000));
    server.run();



    }
}