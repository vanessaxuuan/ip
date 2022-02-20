package gary;
import gary.Storage;
import gary.Parser;
import gary.TaskList;
import gary.GaryException;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a chat-bot that manages your daily to-do list
 */
public class Gary {

    private static Storage storage;
    protected static TaskList tasks;
    protected static Parser parser;

    /**
     * Initializes Storage, TaskList, Ui and Parser required
     *
     * @param filePath file path to file containing history of chat-bot
     */
    public Gary(String filePath) {
        storage = new Storage(filePath);
        parser = new Parser();
        tasks = new TaskList(storage.loadFile());
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    protected String getResponse(String input) {
        String resp;
        try {
            resp = parser.parse(input, tasks);
        } catch (gary.GaryException e) {
            return e.garyError();
        } catch (AssertionError e) {
            return "Sorry... What do you need to do again?";
        }
        return resp;
    }
}