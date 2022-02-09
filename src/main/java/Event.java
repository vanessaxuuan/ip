package gary;
import gary.Task;
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
