package gary;
import gary.Task;

/**
 * Represents a Task that happens on a specific day/time
 * A completed Event e.g. E[X] event_name on: 19-01-2022 10:30pm
 */
public class Event extends Task {
    private String date;

    /**
     * Constructs a new Event object
     *
     * @param str Event name
     * @param date day of Event
     */
    public Event(String str, String date) {
        super(str);
        this.date = date;
    }

    /**
     * Represents Event as a String object
     * e.g. E[X] event_name on: 05-12-2022 23:59pm
     *
     * @return Deadline representation in String
     */
    @Override
    public String toString() {
        return "E" + super.toString() + " on: " + date;
    }
}
