package Commands;

import Exceptions.WrongCommandSyntax;
import Exceptions.WrongTicketData;
import TicketStuff.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Класс, описывающий команду, которая обновляет элемент коллекции по полю id.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class UpdateId implements Command{
    private PriorityQueue<Ticket> queue;
    private Scanner scanner;
    private long id;
    public UpdateId(PriorityQueue<Ticket> queue, Scanner scanner, long id) throws WrongCommandSyntax {
        if (id > queue.size() || id < 0){
            throw new WrongCommandSyntax("Элемента с таким id не существует");
        }
        this.id = id;
        this.queue = queue;
        this.scanner = scanner;
    }


    @Override
    public void execute(){
        Ticket ticket = new Ticket();
        while (true){
            try {
                if (ticket.getId() == null){
                    ticket.setId(this.id);
                }
                if (ticket.getName() == null){
                    System.out.print("Введите название билета: ");
                    ticket.setName(scanner.nextLine());
                }
                if (ticket.getCoordinates() == null){
                    System.out.print("Введите координаты (в формате: x y): ");
                    String[] coords = scanner.nextLine().split(" ");
                    ticket.setCoordinates(new Coordinates(Integer.parseInt(coords[0]), Double.valueOf(coords[1])));
                }
                if (ticket.getPrice() == null){
                    System.out.print("Введите цену билета: ");
                    ticket.setPrice(Float.valueOf(scanner.nextLine()));
                }
                if (ticket.getType() == null){
                    System.out.println("Выберете тип билета:");
                    System.out.println("1 - VIP");
                    System.out.println("2 - USUAL");
                    System.out.println("3 - BUDGETARY");
                    System.out.println("4 - CHEAP");
                    System.out.println("Введите цифру от 1 до 4:");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if( !(1 <= choice && choice <= 4)){
                        throw new WrongTicketData("Нужно ввести цифру от 1 до 4");
                    }
                    switch (choice){
                        case 1:
                            ticket.setType(TicketType.VIP);
                            break;
                        case 2:
                            ticket.setType(TicketType.USUAL);
                            break;
                        case 3:
                            ticket.setType(TicketType.BUDGETARY);
                            break;
                        case 4:
                            ticket.setType(TicketType.CHEAP);
                            break;
                    }
                }
                if (ticket.getEvent() == null){
                    System.out.println("Заполните информацию о мероприятии");
                    System.out.println("Введите строку (в формате: Название Кол-во билетов Описание(если его нет введите -): ");
                    String[] string = scanner.nextLine().split(" ");
                    if (string.length != 3){
                        throw new WrongTicketData("Неверно заполнена информация о мероприятии");
                    }
                    String description = string[2];
                    if (string[2].equals("-")){
                        description = null;
                    }
                    ticket.setEvent(new Event(string[0], Integer.parseInt(string[1]), description));
                }
                break;
            } catch (WrongTicketData wrongTicketData){
                System.out.println(wrongTicketData.getMessage());
            }
        }
        List<Ticket> tempList = new ArrayList<Ticket>();
        for (Ticket t: this.queue){
            if (t.getId() == this.id){
                t = ticket;
                System.out.println("Элемент успешно изменен, чтобы сохранить изменения введите save");
            }
            tempList.add(t);
        }
        this.queue.clear();
        this.queue.addAll(tempList);
    }
}
