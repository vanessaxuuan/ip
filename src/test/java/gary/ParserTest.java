package gary;
import gary.TaskList;
import gary.Parser;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {

    /**
     * Test for the correctness of gary.Parser class
     * Checking if User Input "bye" will terminate chat-bot
     */
    @Test
    public void testBye() {
        Parser p = new Parser();
        TaskList t = new TaskList(new ArrayList<String>());
        assertEquals(true, p.parse("bye", t));
    }
}
