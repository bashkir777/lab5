package Commands;

import TicketStuff.Ticket;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду выводящую в стандартный поток вывода элемент, значения поля name, которого содержит введенное значение.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class FilterContainsName implements Command {
    private PriorityQueue<Ticket> queue;
    private String name;

    public FilterContainsName(PriorityQueue<Ticket> queue, String name) {
        this.queue = new PriorityQueue<Ticket>(queue);
        this.name = name;
    }

    @Override
    public void execute() {
        while (queue.peek() != null) {
            if (queue.peek().getName().contains(name)){
                System.out.println(queue.peek());
            }
            queue.poll();
        }
    }
}