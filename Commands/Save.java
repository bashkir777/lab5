package Commands;

import CollectionInteraction.CollectionInteraction;
import TicketStuff.Ticket;
import java.io.IOException;
import java.util.PriorityQueue;
/**
 * Класс, описывающий команду, которая сохраняет все изменения коллекции.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Save implements Command{
    private CollectionInteraction interaction;
    private PriorityQueue<Ticket> queue;
    public Save(CollectionInteraction interaction, PriorityQueue<Ticket> queue){
        this.interaction = interaction;
        this.queue = queue;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        interaction.write(queue);
        System.out.println("Изменения успешно сохранены");
    }
}
