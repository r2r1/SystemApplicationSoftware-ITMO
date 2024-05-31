import clientCommand.ExecuteScriptCommand;
import clientCommand.InsertCommand;
import clientCommand.UpdateCommand;
import model.SpaceMarine;
import service.CommandManager;
import service.Network;
import service.SpaceMarineAsker;

import java.io.File;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

import static service.PromptScan.getUserScanner;
import static service.PromptScan.setUserScanner;

// TODO: зависает клиент, когда кидает данные на сервер во время его работы с другим клиентом

// TODO: 2 клиента, при выключение сервера,  клиенты не должны зависать, а все равно должны пытаться коннектится
public class Main {

    public static void main(String[] args) throws Exception {
        Network network = new Network();
        setUserScanner(new Scanner(System.in));
        Scanner scanner = getUserScanner();
        CommandManager.init();
        System.out.println("> Напишите run, чтобы подключиться к серверу!");
        while (true) {
            DatagramChannel channel = network.getChannel();
            channel.socket().setSoTimeout(2000);
            setUserScanner(new Scanner(System.in));
            System.out.print("> ");
            String command = scanner.nextLine();

// execute_script src/script1.txt
            CommandManager.executeCommand(command);

        }

}

}

