package Commands;

import TicketStuff.Ticket;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду, которая выводит в стандартный поток вывода все элементы коллекции.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Show implements Command{
    private PriorityQueue<Ticket> queue;
    public Show(PriorityQueue<Ticket> queue){
        this.queue = queue;
    }

    @Override
    public void execute() {
        for(Ticket ticket: queue){
            System.out.println(ticket);
        }
    }
}
