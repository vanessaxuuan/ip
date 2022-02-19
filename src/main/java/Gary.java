package gary;
import gary.Storage;
import gary.Ui;
import gary.Parser;
import gary.TaskList;
import gary.GaryException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a chat-bot that manages your daily to-do list
 */
public class Gary {

    private static Storage storage;
    protected static TaskList tasks;
    private static Ui ui;
    protected static Parser parser;

    /**
     * Initializes Storage, TaskList, Ui and Parser required
     *
     * @param filePath file path to file containing history of chat-bot
     */
    public Gary(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        tasks = new TaskList(storage.loadFile());
    }

}