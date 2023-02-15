package CollectionInteraction;
import TicketStuff.Ticket;
import java.io.*;
import java.util.PriorityQueue;
/**
 * Класс, описывающий объект, позволяющий получать коллекцию из файла и сохранять ее в файл.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class FileInteraction implements CollectionInteraction{
    public final String sourceName;
    public FileInteraction(String sourceName) throws IOException{
        this.sourceName = sourceName;
    }

    public PriorityQueue<Ticket> read() throws ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(this.sourceName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (PriorityQueue<Ticket>) ois.readObject();
    }
    public void write(PriorityQueue<Ticket> queue) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.sourceName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(queue);
    }

    @Override
    public String getSource() {
        return this.sourceName;
    }
}
