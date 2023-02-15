package Exceptions;
/**
 * Класс, описывающий ошибку, возникающую при вводе неправильного значения какого-либо поля объекта класса Ticket.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class WrongTicketData extends Exception{
    private String message;
    public WrongTicketData(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
