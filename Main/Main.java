package Main;

import CollectionInteraction.CollectionInteraction;
import CollectionInteraction.FileInteraction;
import Commands.*;
import Exceptions.ScriptNotFound;
import Exceptions.WrongCommandSyntax;
import TicketStuff.*;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    public static void main(String... args) throws ClassNotFoundException {
        String filePath = args[0];

        try{
            Scanner scanner = new Scanner(System.in);
            CollectionInteraction interaction = new FileInteraction(filePath);
            PriorityQueue<Ticket> queue;
            try{
                queue = interaction.read();
            }catch (Exception e){
                queue = new PriorityQueue<Ticket>();
            }
            while (true){
                Command cmd = null;
                String line = null;

                System.out.println("Введите команду: ");

                /*
                String[] line = scanner.nextLine().split(" ");
                String command = line[0];
                */

                line = scanner.nextLine();
                cmd = CommandRegistrar.findCommand(line, scanner, queue, interaction);
                /*
                switch (command){
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
                        cmd = new FilterContainsName(queue, line[1]);
                        break;
                    case "filter_by_event":
                        cmd = new FilterByEvent(queue, scanner);
                        break;
                    case "remove_by_id":
                        cmd = new RemoveById(queue, Long.parseLong(line[1]));
                        break;
                    case "add_if_max":
                        cmd = new AddIfMax(scanner, queue);
                        break;
                    case "update_id":
                        cmd = new UpdateId(queue, scanner, Long.parseLong(line[1]));
                        break;
                    case "help":
                        cmd = new Help();
                        break;
                    default:
                        System.out.println("Такой команды не существует, чтобы открыть список существующих команд введите help");
                        continue;
                }*/
                cmd.execute();
            }
        }catch (IOException e){
            System.out.println("Файл с таким названием не найден");
            System.exit(0);
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException | WrongCommandSyntax e){
            System.out.println("Неверный синтаксис команды, чтобы открыть список существующих команд введите help");
            Main.main(filePath);
        }catch (ScriptNotFound e){
            System.out.println(e.getMessage());
        }
    }
}



