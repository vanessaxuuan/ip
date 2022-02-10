package gary;

/**
 * Represents a task
 * A completed task e.g. [X] task_name
 */
public class Task {
    protected String task;
    protected boolean isDone;

    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }

    public void toMark() {
        this.isDone = true;
    }

    public void toUnmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String done = this.isDone ? "X" : " ";
        return "[" + done + "] " + this.task;
    }
}