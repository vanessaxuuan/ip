package gary;
import gary.Event;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EventTest {

    /**
     * Test for the correctness of gary.Event class
     */
    @Test
    public void testEvent() {
        Event e = new Event("party", "12 Jan 2022 10:30pm");
        assertEquals("E[ ] party on: 12 Jan 2022 10:30pm", e.toString());
    }
}
