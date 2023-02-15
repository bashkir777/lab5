package Commands;
import CollectionInteraction.CollectionInteraction;
import Exceptions.ScriptNotFound;
import Exceptions.WrongCommandSyntax;
import TicketStuff.Ticket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Класс, описывающий команду применяемую для исполнения сккрипта, находящегося в стороннем файле
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class ExecuteScript implements Command{
    PriorityQueue<Ticket> queue;
    CollectionInteraction interaction;
    String pathToScript;
    public ExecuteScript(PriorityQueue<Ticket> queue, CollectionInteraction interaction,String pathToScript){
        this.queue = queue;
        this.interaction = interaction;
        this.pathToScript = pathToScript;
    }

    @Override
    public void execute() throws ClassNotFoundException, ScriptNotFound, FileNotFoundException {
        Scanner scriptScanner = new Scanner(new File(pathToScript));
        try{
            while (true){
                String command = scriptScanner.nextLine();
                CommandRegistrar.findCommand(command, scriptScanner, this.queue, this.interaction).execute();
            }
        }catch (NoSuchElementException e){
            System.out.println("Скрипт выполнен");
        } catch (WrongCommandSyntax| IOException e) {
            System.out.println("Что-то пошло не так...");
        }
    }
}
