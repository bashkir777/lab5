package Commands;

import Exceptions.WrongTicketData;
import TicketStuff.Coordinates;
import TicketStuff.Event;
import TicketStuff.Ticket;
import TicketStuff.TicketType;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Класс, описывающий команду, которая добавляет элемент в коллекцию, если он больше максимального элемента в коллекции
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class AddIfMax implements Command{
    private Scanner scanner;
    private PriorityQueue<Ticket> queue;
    private PriorityQueue<Ticket> queueCopy;
    public AddIfMax(Scanner scanner, PriorityQueue<Ticket> queue){
        this.scanner = scanner;
        this.queue = queue;
        this.queueCopy = new PriorityQueue<Ticket> (queue);
    }

    @Override
    public void execute() {
        Ticket ticket = new Ticket();
        while (true){
            try {
                if (ticket.getId() == null){
                    ticket.setId((long) (queue.size() + 1));
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


                float max = -1;
                for (Ticket ticket1 : queueCopy) {
                    if (ticket1.getPrice() > max){
                        max = ticket1.getPrice();
                    }
                }
                if(ticket.getPrice() > max){
                    queue.add(ticket);
                    System.out.println("Объект добавлен, чтобы сохранить изменения введите команду save");
                    break;
                }
                System.out.println("Объект не был добавлен");
                break;
            } catch (WrongTicketData wrongTicketData){
                System.out.println(wrongTicketData.getMessage());
            }
        }


    }
}
