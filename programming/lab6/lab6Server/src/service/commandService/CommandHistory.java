package service.commandService;

import java.util.ArrayList;
import java.util.List;

import static service.commandService.CommandExecutor.*;

public class CommandHistory {
    static List<String> commandList = new ArrayList<>();

    public void addCommand(String command) {
        if ( commandsMap.get(command) != null) commandList.add(command);

    }
    public static List<String>  getCommandList() {
        return commandList;
    }


}
