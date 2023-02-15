package Commands;

import TicketStuff.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду удаляющую элементы из коллекции по полю id.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class RemoveById implements Command{
    private PriorityQueue<Ticket> queue;
    private PriorityQueue<Ticket> queueCopy;
    private long id;
    public RemoveById(PriorityQueue<Ticket> queue, long id){
        this.queue = queue;
        this.queueCopy = new PriorityQueue<Ticket>(queue);
        this.id = id;
    }

    @Override
    public void execute(){
        List<Ticket> tempList = new ArrayList<Ticket>();
        boolean DeleteSuccess = false;
        for (Ticket ticket: queueCopy){
            if (ticket.getId() == this.id){
                DeleteSuccess = true;
                continue;
            }
            tempList.add(ticket);
        }
        if (DeleteSuccess){
            for(Ticket ticket: tempList){
                if (ticket.getId() > this.id){
                    ticket.setId(ticket.getId()-1);
                }
            }
        }
        this.queue.clear();
        this.queue.addAll(tempList);
        if (DeleteSuccess){
            System.out.println("Удаление прошло успешно, чтобы сохранить изменения введите команду save");
        }else {
            System.out.println("Элемент с таким id не найден");
        }
    }
}
