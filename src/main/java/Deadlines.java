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
