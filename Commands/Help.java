package Commands;
/**
 * Класс, описывающий команду выводящую в стандартный поток вывода элемент, справку по всем доступным командам.
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public class Help implements Command {

    @Override
    public void execute() {
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_first : удалить первый элемент из коллекции");
        System.out.println("remove_head : вывести первый элемент коллекции и удалить его");
        System.out.println("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("filter_by_event event : вывести элементы, значение поля event которых равно заданному");
        System.out.println("filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");
        System.out.println("print_field_ascending_price : вывести значения поля price всех элементов в порядке возрастания");
    }
}
