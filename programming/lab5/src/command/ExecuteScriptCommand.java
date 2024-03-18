package command;

import command.interfaces.Command;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import service.PromptScan;
import service.StreamService;

public class ExecuteScriptCommand implements Command {
    static String path = "";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void executeFromConsole(String path) throws IOException {
        ExecuteScriptCommand.path = path;
        File file = new File(path);

        PromptScan.setUserScanner(new Scanner(file));
        Scanner scriptScanner = PromptScan.getUserScanner();

        while (scriptScanner.hasNext()) {
            String command = scriptScanner.nextLine();
            StreamService streamService = new StreamService(command, false);
            streamService.start();
        }
    }

    Set<String> processedScripts = new HashSet<>();

    @Override
    public void executeFromFile(String argument) throws IOException {
        File file = new File(argument);
        String[] commandsFromFile = getCommandsFromFile(file);

        if (!isRecursion(commandsFromFile)) {
            executeFromConsole(argument);
        }
        processedScripts.clear();
    }

    public String[] getCommandsFromFile(File filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(filePath);
        List<String> commandFromFile = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.split(" ")[0].equals("execute_script")) {
                commandFromFile.add(command.split(" ")[1]);
            }
        }
        return commandFromFile.toArray(new String[0]);
    }

    public boolean isRecursion(String[] files) {
        for (String file : files) {
            processedScripts.add(file);
            if (processedScripts.contains(ExecuteScriptCommand.path)) {
                System.out.println(ANSI_RED + "Рекурсия в файле: " + file + ANSI_RESET);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
