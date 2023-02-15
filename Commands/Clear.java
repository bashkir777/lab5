package Commands;

import CollectionInteraction.CollectionInteraction;
import TicketStuff.Ticket;
import java.util.PriorityQueue;

/**
 * Класс, описывающий команду, которая удаляет все элементы из коллекции
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Clear implements Command{
    private CollectionInteraction interaction;
    public Clear(CollectionInteraction interaction, PriorityQueue<Ticket> queue){
        queue.clear();
        this.interaction = interaction;
    }
    @Override
    public void execute(){
        System.out.println("Все элементы удалены из коллекции, чтобы сохранить изменения введите команду save");
    }
}
