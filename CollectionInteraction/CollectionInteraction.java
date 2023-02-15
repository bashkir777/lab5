package CollectionInteraction;
import TicketStuff.Ticket;
import java.io.IOException;
import java.util.PriorityQueue;
/**
 * Интерфейс, который должен исполнять каждый класс, способный читать или сохранять коллекцию из/в какого-либо/какой-либо источник(а).
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public interface CollectionInteraction {
    public PriorityQueue<Ticket> read() throws ClassNotFoundException, IOException;

    public void write(PriorityQueue<Ticket> queue) throws IOException;
    public String getSource();
}
