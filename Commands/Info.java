package Commands;

import CollectionInteraction.CollectionInteraction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 * Класс, описывающий команду выводящую в стандартный поток вывода информацию о коллекции.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Info implements Command{
    private File file;
    private CollectionInteraction interaction;
    public Info(CollectionInteraction interaction){
        this.interaction = interaction;
        this.file = new File(interaction.getSource());
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.println();
        System.out.println("Тип коллекции: PriorityQueue<Ticket>");
        System.out.println("В коллекции содержится "+ interaction.read().size() + " элемент(ов)");
        System.out.println("Последний раз коллекция изменялась "+ new Date(file.lastModified()));
        System.out.println("Объем, занимаемый коллекцией " + file.length() + " байт");
    }
}
