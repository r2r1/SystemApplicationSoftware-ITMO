package clientCommand;


import service.CommandManager;
import service.Network;
import service.PromptScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveAction;



public class ExecuteScriptCommand implements Command{
        Network network = new Network();
        String path = "";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_RESET = "\u001B[0m";
        Command command;




        String argumentString;
        String commandString;

        public ExecuteScriptCommand() throws IOException {
        }

        @Override
        public void execute(String path) throws IOException {
            try {
                this.path = path;
                File file = new File(path);
                if (!isRecursion(getPaths(new File(path)))){
                    PromptScan.setUserScanner(new Scanner(file));
                    Scanner scriptScanner = PromptScan.getUserScanner();

                    while (scriptScanner.hasNext()) {

                        String[] commandSplit = scriptScanner.nextLine().trim().split(" ");
                        commandString = commandSplit[0] ;

                        try {
                            argumentString = commandSplit[1] ;
                        }catch (ArrayIndexOutOfBoundsException ignored){
                        }

                        System.out.println("выполнение " + commandString);
                        CommandManager.executeCommand(commandString + " " + argumentString);
                    }


                }
                processedScripts.clear();
            path = "";
            }catch (FileNotFoundException e){
                System.out.println("Не существует файла по адресу: " + path);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        Set<String> processedScripts = new HashSet<>();


 /*       public void executeFromFile(String argument) throws IOException {
            File file = new File(argument);
            String[] commandsFromFile = getCommandsFromFile(file);

            if (!isRecursion(commandsFromFile)) {
                executeFromConsole(argument);
            }
            processedScripts.clear();
        }
*/
        public String[] getPaths(File filePath) throws FileNotFoundException {
            Scanner scanner = new Scanner(filePath);
            List<String> pathsFromFile = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                if (command.split(" ")[0].equals("execute_script")) {
                    pathsFromFile.add(command.split(" ")[1]);
                }
            }
            return pathsFromFile.toArray(new String[0]);
        }

        public String[] getCommandsFromFile(File filePath) throws FileNotFoundException {
            Scanner scanner = new Scanner(filePath);
            List<String> commandFromFile = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                commandFromFile.add(command);
            }
            return commandFromFile.toArray(new String[0]);
        }

        public boolean isRecursion(String[] files) {
            for (String file : files) {
                processedScripts.add(file);
                if (processedScripts.contains(path)) {
                    System.out.println(ANSI_RED + "Рекурсия в файле: " + file + ANSI_RESET);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }


    }

