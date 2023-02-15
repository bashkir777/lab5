package Commands;

import Exceptions.ScriptNotFound;

import java.io.IOException;
/**
 * Интерфейс, который должна исполнять каждая команда
 * @author Supletsov Dmitriy "supletsovd@gmail.com"
 */
public interface Command {
    public void execute() throws IOException, ClassNotFoundException, ScriptNotFound;
}
