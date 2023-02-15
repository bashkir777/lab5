package Commands;

import CollectionInteraction.CollectionInteraction;
import Commands.*;
import Exceptions.WrongCommandSyntax;
import TicketStuff.Ticket;

import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Класс для регистрации новых команд
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class CommandRegistrar {
    public static Command findCommand(String command, Scanner scanner, PriorityQueue<Ticket> queue, CollectionInteraction interaction) throws WrongCommandSyntax {
        Command cmd = null;
        String[] commandArr = command.split(" ");
        switch (commandArr[0]){
            case "add":
                cmd = new Add(scanner, queue);
                break;
            case "save":
                cmd = new Save(interaction, queue);
                break;
            case "show":
                cmd = new Show(queue);
                break;
            case "clear":
                cmd = new Clear(interaction, queue);
                break;
            case "info":
                cmd = new Info(interaction);
                break;
            case "remove_first":
                cmd = new RemoveFirst(queue);
                break;
            case "remove_head":
                cmd = new RemoveHead(queue);
                break;
            case "exit":
                System.exit(0);
                break;
            case "print_field_ascending_price":
                cmd = new PrintFieldAscendingPrice(queue);
                break;
            case "filter_contains_name":
                cmd = new FilterContainsName(queue, commandArr[1]);
                break;
            case "filter_by_event":
                cmd = new FilterByEvent(queue, scanner);
                break;
            case "remove_by_id":
                cmd = new RemoveById(queue, Long.parseLong(commandArr[1]));
                break;
            case "add_if_max":
                cmd = new AddIfMax(scanner, queue);
                break;
            case "update_id":
                cmd = new UpdateId(queue, scanner, Long.parseLong(commandArr[1]));
                break;
            case "help":
                cmd = new Help();
                break;
            case "execute_script":
                cmd = new ExecuteScript(queue, interaction, commandArr[1]);
                break;
            default:
                throw new WrongCommandSyntax("Такой команды не существует, чтобы открыть список существующих команд введите help");

        }
        return cmd;
    }
}
