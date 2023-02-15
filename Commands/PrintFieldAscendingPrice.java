package Commands;

import TicketStuff.Ticket;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду выводящую в стандартный поток вывода в порядке возрастания значения полей price всех элементов.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class PrintFieldAscendingPrice implements Command{
    private PriorityQueue<Ticket> queue;
    public PrintFieldAscendingPrice(PriorityQueue<Ticket> queue){
        this.queue = new PriorityQueue<Ticket>(queue);
    }

    @Override
    public void execute(){
        while(queue.peek() != null){
            System.out.println(queue.poll().getPrice());
        }
    }
}
