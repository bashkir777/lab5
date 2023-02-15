package Commands;

import TicketStuff.Ticket;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду удаляющую первый элемент коллекции.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class RemoveFirst implements Command{
    private PriorityQueue<Ticket> queue;
    public RemoveFirst(PriorityQueue<Ticket> queue){
        this.queue = queue;
    }

    @Override
    public void execute(){
        queue.poll();
        System.out.println("Объект удален, чтобы сохранить изменения введите команду save");
    }
}
