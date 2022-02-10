package gary;

/**
 * Represents a task
 * A completed task e.g. [X] task_name
 */
public class Task {
    protected String task;
    protected boolean isDone;

    /**
     * Constructs a new Task object
     *
     * @param task task name
     */
    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }

    /**
     * Marks a Task as completed e.g. [X]
     */
    public void toMark() {
        this.isDone = true;
    }

    /**
     * Marks a Task as incomplete e.g. [ ]
     */
    public void toUnmark() {
        this.isDone = false;
    }

    /**
     * Represents Task as a String object
     * Completed Task e.g. [X] task_name
     *
     * @return Task representation in String
     */
    @Override
    public String toString() {
        String done = this.isDone ? "X" : " ";
        return "[" + done + "] " + this.task;
    }
}