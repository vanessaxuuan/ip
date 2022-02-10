package gary;
import gary.TaskList;
import gary.Parser;
import java.util.Scanner;

/**
 * Takes in user inputs for Gary chat-bot to operate
 */
public class Ui {

    /**
     * @param tsk TaskList saved in history
     */
    public void welcomeUser(TaskList tsk) {
        System.out.println("Hello, i'm Gary!\n");
        tsk.printList(1);
    }

    /**
     * @param par Parser to be used
     * @param tsk TaskList to be updated
     * @return indication to end of user input
     */
    public boolean startBot(Parser par, TaskList tsk) {
        Scanner sc = new Scanner(System.in);
        String nxt = sc.nextLine();
        return par.parse(nxt, tsk);
    }
}