package gary;
import gary.TaskList;
import gary.Parser;
import java.util.Scanner;

public class Ui {

    public Ui() {
    }

    public void welcomeUser(TaskList tsk) {
        System.out.println("Hello, i'm Gary!\n");
        tsk.printList(1);
    }

    public boolean startBot(Parser par, TaskList tsk) {
        Scanner sc = new Scanner(System.in);
        String nxt = sc.nextLine();
        return par.parse(nxt, tsk);
    }
}