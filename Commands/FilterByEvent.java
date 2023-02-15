package Commands;

import TicketStuff.Ticket;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Класс, описывающий команду выводящую в стандартный поток вывода элемент, значения поля event, которого совпадает с введенным
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class FilterByEvent implements Command{
    private PriorityQueue<Ticket> queue;
    private Scanner scanner;
    public FilterByEvent(PriorityQueue<Ticket> queue, Scanner scanner){
        this.queue = new PriorityQueue<Ticket>(queue);
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите название Event'a: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество билетов на Event: ");
        long ticketsCount = Long.parseLong(scanner.nextLine());

        while (queue.peek() != null){
            if (queue.peek().getEvent().getName().equals(name) && queue.peek().getEvent().getTicketsCount()==ticketsCount){
                System.out.println(queue.peek());
            }
            queue.poll();
        }
    }
}
