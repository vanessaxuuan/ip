package gary;
import gary.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskTest {

    /**
     * Test for the correctness of gary.Task.mark() method
     */
    @Test
    public void markingTest() {
        Task t = new Task("testing");
        t.toMark();
        assertEquals("[X] testing", t.toString());
    }

    /**
     * Test for the correctness of gary.Task.unmark() method
     */
    @Test
    public void unmarkingTest() {
        Task t = new Task("un-mark");
        t.toMark();
        t.toUnmark();
        assertEquals("[ ] un-mark", t.toString());
    }
}