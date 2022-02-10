package gary;
import gary.Task;

/**
 * Represents a Task that entails a deadline
 * A completed DeadLines e.g. D[X] deadline_name by: 19-01-2022 10:30pm
 */
public class Deadlines extends Task {
    String date;

    public Deadlines(String str, String date) {
        super(str);
        this.date = date;
    }

    @Override
    public String toString() {
        return "D" + super.toString() + " by: " + date;
    }
}
