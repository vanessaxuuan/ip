package gary;
import gary.ToDo;
import gary.Event;
import gary.Deadline;
import gary.Task;
import gary.GaryException;
import gary.Storage;
import gary.TaskList;
import gary.GaryException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a list of tasks to be done by user
 * Contains a set of operations to be performed on the list
 */
public class TaskList {
    public ArrayList<Task> tasks;

    /**
     * Constructs a new TaskList from a List of String
     *
     * @param t List of String to be decoded
     */
    public TaskList(ArrayList<String> t) {
        tasks = new ArrayList<Task>();
        this.decode(t);
    }

    /**
     * Convert List of Strings into List of Tasks
     *
     * @param lst List of Strings to be decoded into commands
     */
    public void decode(ArrayList<String> lst) {
        for (String str : lst) {
            char type = str.charAt(3);
            boolean isDone = str.charAt(5) == 'X';
            switch (type) {
                case 'T':
                    this.tasks.add(new ToDo(str.substring(8)));
                    break;
                case 'E':
                    String[] e = str.split("on:", 5);
                    this.tasks.add(new Event(e[0].substring(8), e[1]));
                    break;
                case 'D':
                    String[] d = str.split("by:", 5);
                    this.tasks.add(new Deadline(d[0].substring(8), d[1]));
                    break;
            }
            if (isDone) {
                int len = this.tasks.size();
                this.tasks.get(len - 1).toMark();
            }
        }
    }

    /**
     * Calls the method corresponding to user input
     *
     * @param method operation to be performed
     * @throws GaryException if method is invalid
     */
    public void invoke(String method) throws GaryException {
        switch (method) {
            case "list":
                this.printList(2);
                break;
            case "mark":
                this.mark();
                break;
            case "unmark":
                this.unmark();
                break;
            case "delete":
                this.delete();
                break;
            default:
                throw new GaryException(method);
        }
    }

    /**
     * Prints out Task List
     *
     * @param x type of message to be printed
     */
    public void printList(int x) {
        String msg = x == 1 ? "Welcome back, this is your current to-do list:" : "to do list:";
        if (this.tasks.isEmpty()) {
            System.out.println("No history recorded, what would you like to do today?");
        } else {
            System.out.println(msg);
            int i = 1;
            for (Task curr : this.tasks) {
                System.out.printf("%d: %s\n", i, curr);
                i++;
            }
        }
    }

    /**
     * Adds a ToDo Task
     *
     * @param t task to do
     */
    public void addTodo(String t) {
        tasks.add(new ToDo(t));
        Storage.saveTask(tasks);
    }

    /**
     * Adds an Event Task
     *
     * @param e Event to add
     * @param date day of event
     */
    public void addEvent(String e, String date) {
        tasks.add(new Event(e, date));
        Storage.saveTask(tasks);
    }

    /**
     * Adds a Deadline Task
     *
     * @param d DeadLines to add
     * @param date due date
     */
    public void addDeadline(String d, String date) {
        tasks.add(new Deadline(d, date));
        Storage.saveTask(tasks);
    }

    /**
     * Deletes unnecessary tasks
     */
    public void delete() {
        System.out.println("Please key in what you would like to remove in descending order!");
        try {
            Scanner sc = new Scanner(System.in);
            String nums = sc.nextLine();
            String[] first = nums.split(" ");
            int k = 0;
            for (String str : first) {
                tasks.remove(Integer.parseInt(first[k]) - 1);
                k++;
            }
            printList(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ah please enter a valid number or sequence e.g. 5 3 1");
        }
        if(!tasks.isEmpty()) {
            Storage.saveTask(tasks);
        }
    }

    /**
     * Marks completed task as done
     */
    public void mark() {
        System.out.println("which tasks have you completed? e.g. 2 3");
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        String[] first = nums.split(" ");
        int i = 0;
        for (String str : first) {
            tasks.get(Integer.parseInt(first[i]) - 1).toMark();
            i++;
        }
        Storage.saveTask(tasks);
        System.out.print("Alright, this is your updated ");
        printList(2);
    }

    /**
     * Undo marking
     */
    public void unmark() {
        System.out.println("made some mistakes, which tasks would you want to un-mark?");
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        String[] first = nums.split(" ");
        int k = 0;
        for (String str : first) {
            tasks.get(Integer.parseInt(first[k]) - 1).toUnmark();
            k++;
        }
        Storage.saveTask(tasks);
        System.out.print("Alright, this is your updated ");
        printList(2);
    }

    /**
     * Print out Tasks that contains keyword
     *
     * @param keyword
     */
    public void find(String keyword) {
        int i = 0;
        System.out.println("Here are the matching tasks in your list:");
        for(Task t : tasks) {
            if (t.contain(keyword)) {
                i++;
                System.out.printf("%d. %s\n", i, t.toString());
            }
        }
        if (i == 0) {
            System.out.println("no match found :(");
        }
    }
}
