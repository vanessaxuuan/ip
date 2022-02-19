package gary;
import gary.TaskList;
import gary.Parser;
import java.util.Scanner;

/**
 * Takes in user inputs for Gary chat-bot to operate
 */
public class Ui {

    /**
     * Prints welcome message and history
     *
     * @param tsk TaskList saved in history
     */
    public void welcomeUser(TaskList tsk) {
        // System.out.println("Hello, i'm Gary!\n");
        // tsk.printList(1);
    }

//    /**
//     * Get user input
//     *
//     * @param par Parser to be used
//     * @param tsk TaskList to be updated
//     * @return indication to end of user input
//     */
//    public String startBot(Parser par, TaskList tsk) {
//        return par.parse(nxt, tsk);
//    }
}