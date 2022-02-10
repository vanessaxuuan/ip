package gary;
import gary.Task;
import gary.GaryException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskListTest {
    private ArrayList<String> commands;
    private gary.TaskList lst;

    /**
     * Test for the correctness of gary.TaskList class
     * Check if gary.TaskList.invoke() is able to detect invalid input
     */
    @Test
    public void testInvokeError() throws GaryException {
        try {
            commands = new ArrayList<>();
            commands.add("3. E[ ] party on: 12 Dec 2001 22:30 pm");
            lst = new gary.TaskList(commands);
            lst.invoke("hello");
        } catch (GaryException e) {
            assertEquals("hello", e.msg);
        }
    }
}
