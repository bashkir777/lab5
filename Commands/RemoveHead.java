package Commands;

import TicketStuff.Ticket;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду, которая удаляет первый элемент коллекции и выводит его в стандартный поток вывода.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class RemoveHead implements Command{
    private PriorityQueue<Ticket> queue;
    public RemoveHead(PriorityQueue<Ticket> queue){
        this.queue = queue;
    }

    @Override
    public void execute(){
        System.out.println("Удаляемый объект: " + queue.poll());
        System.out.println("Объект удален, чтобы сохранить изменения введите команду save");
    }
}