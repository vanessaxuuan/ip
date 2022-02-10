package gary;
import gary.Task;

/**
 * Represents a Task that happens on a specific day/time
 * A completed Event e.g. E[X] event_name on: 19-01-2022 10:30pm
 */
public class Event extends Task {
    String date;

    public Event(String str, String date) {
        super(str);
        this.date = date;
    }

    @Override
    public String toString() {
        return "E" + super.toString() + " on: " + date;
    }
}
