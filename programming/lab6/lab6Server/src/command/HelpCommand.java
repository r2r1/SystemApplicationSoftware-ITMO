package command;

import command.interfaces.Command;
import network.Network;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class HelpCommand implements Command {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    String argument;

    @Override
    public void execute(String argument,  DatagramChannel channel) throws IOException {
        this.argument = argument;
        Network network = new Network(channel);
        String response =  ANSI_YELLOW+ "help " + ANSI_RESET + " : вывести справку по доступным командам \n" +
                ANSI_YELLOW+ "info " + ANSI_RESET + " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n" +
                ANSI_YELLOW+ "show " + ANSI_RESET + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                ANSI_YELLOW+ "insert null {element} " + ANSI_RESET + " : добавить новый элемент с заданным ключом \n"+
                ANSI_YELLOW+ "update id {element} " + ANSI_RESET + " : обновить значение элемента коллекции, id которого равен заданному \n"
                +ANSI_YELLOW+ "remove_key null " + ANSI_RESET + "  : удалить элемент из коллекции по его ключу \n"
                +ANSI_YELLOW+ "clear " + ANSI_RESET + " : очистить коллекцию \n"
                +ANSI_YELLOW+ "save " + ANSI_RESET + " : сохранить коллекцию в файл \n"
                +ANSI_YELLOW+ "execute_script file_name " + ANSI_RESET + " : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n"
                +ANSI_YELLOW+ "exit " + ANSI_RESET + " : завершить программу (без сохранения в файл) \n"
                +ANSI_YELLOW+ "remove_greater {element} " + ANSI_RESET + " : удалить из коллекции все элементы, превышающие заданный \n"
                +ANSI_YELLOW+ "replace_if_lowe null {element} " + ANSI_RESET + " : заменить значение по ключу, если новое значение меньше старого \n"
                +ANSI_YELLOW+ "remove_greater_key null " + ANSI_RESET + "  : удалить из коллекции все элементы, ключ которых превышает заданный \n"
                +ANSI_YELLOW+ "count_greater_than_weapon_type weaponType " + ANSI_RESET + " : вывести количество элементов, значение поля weaponType которых больше заданного \n"
                +ANSI_YELLOW+ "filter_less_than_chapter chapter " + ANSI_RESET + " : вывести элементы, значение поля chapter которых меньше заданного \n"
                +ANSI_YELLOW+ "print_field_descending_category " + ANSI_RESET + " : вывести значения поля category всех элементов в порядке убывания \n"
                +ANSI_YELLOW+ "max_by_health " + ANSI_RESET + " : вывести максимальное значение health";

        network.send(response);
    }



}
