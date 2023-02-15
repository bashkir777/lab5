package Commands;

import Exceptions.WrongTicketData;
import TicketStuff.*;

import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Класс, описывающий команду применяемую для добавления элемента в коллекцию
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Add implements Command{
    private Scanner scanner;
    private PriorityQueue<Ticket> queue;
    public Add(Scanner scanner, PriorityQueue<Ticket> queue){
        this.scanner = scanner;
        this.queue = queue;
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
                    try{
                        ticket.setCoordinates(new Coordinates(Integer.parseInt(coords[0]), Double.valueOf(coords[1])));
                    }catch (Exception e){
                        throw new WrongTicketData("");
                    }

                }
                if (ticket.getPrice() == null){
                    System.out.print("Введите цену билета: ");

                    try{
                        float price = Float.parseFloat(scanner.nextLine());
                        if (price < 0){
                            throw new WrongTicketData("");
                        }
                        ticket.setPrice(price);
                    }catch(Exception e){
                        throw new WrongTicketData("Цена должна быть положительным числом");
                    }

                }
                if (ticket.getType() == null) {
                    System.out.println("Выберете тип билета:");
                    System.out.println("1 - VIP");
                    System.out.println("2 - USUAL");
                    System.out.println("3 - BUDGETARY");
                    System.out.println("4 - CHEAP");
                    System.out.println("Введите цифру от 1 до 4:");
                    int choice;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        throw new WrongTicketData("Нужно ввести цифру от 1 до 4");
                    }
                    if (!(1 <= choice && choice <= 4)) {
                        throw new WrongTicketData("Нужно ввести цифру от 1 до 4");
                    }
                    switch (choice) {
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
                queue.add(ticket);
                System.out.println("Объект добавлен, чтобы сохранить изменения введите команду save");
                break;
            } catch (WrongTicketData wrongTicketData){
                System.out.println(wrongTicketData.getMessage());
            }
        }


    }
}
