package gary;
import gary.Storage;
import gary.Ui;
import gary.Parser;
import gary.TaskList;
import gary.GaryException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gary {

    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;
    private static Parser parser;

    public Gary(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        tasks = new TaskList(storage.loadFile());
    }

    public static void main(String[] args) throws GaryException {
        new Gary("./gary.txt").run();
    }

    public static void run() {
        boolean isEnd = false;
        ui.welcomeUser(tasks);
        while (!isEnd) {
            isEnd = ui.startBot(parser, tasks);
        }
    }
}