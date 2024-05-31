/*


import java.io.IOException;
import java.util.Scanner;
import service.PromptScan;
import service.StreamService;


public class ConsoleApp {
    public static void main(String[] args) throws IOException {

        PromptScan.setUserScanner(new Scanner(System.in));
        Scanner consoleScanner = PromptScan.getUserScanner();


        while (true) {
            PromptScan.setUserScanner(new Scanner(System.in));
            System.out.print("> ");
            String command = consoleScanner.nextLine().trim();
            StreamService streamService = new StreamService(command, true);
            streamService.start();
        }
    }
} */