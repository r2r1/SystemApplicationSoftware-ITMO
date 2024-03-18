import collection.SpaceMarineCollection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import service.PromptScan;
import service.StreamService;
import service.dataProviderService.JSONProvider;

public class ConsoleApp {
    public static void main(String[] args) throws IOException {

        PromptScan.setUserScanner(new Scanner(System.in));
        Scanner consoleScanner = PromptScan.getUserScanner();
        SpaceMarineCollection spaceMarineCollection = new SpaceMarineCollection();

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
                System.out.print(
                        "> Прошлый запуск программы был звершен досрочно, хотите ли вы вернуть коллекцию?");
                System.out.print("> (y/n) : ");
                String answer = consoleScanner.nextLine().trim().toLowerCase();
                if (answer.equals("y")) {
                    spaceMarineCollection.loadCollectionFromJson("tmp.json");
                    System.out.println("> Коллекция возобновлена!");
                } else
                    jsonProvider.clear();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            PromptScan.setUserScanner(new Scanner(System.in));
            System.out.print("> ");
            String command = consoleScanner.nextLine().trim();
            StreamService streamService = new StreamService(command, true);
            streamService.start();
        }
    }
}