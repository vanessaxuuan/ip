package gary;
import gary.ToDo;
import gary.Event;
import gary.Deadlines;
import gary.Task;
import gary.GaryException;
import gary.Storage;
import gary.TaskList;
import gary.GaryException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    public ArrayList<Task> tasks;

    public TaskList(ArrayList<String> t) {
        tasks = new ArrayList<Task>();
        this.decode(t);
    }

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
                    this.tasks.add(new Deadlines(d[0].substring(8), d[1]));
                    break;
            }
            if (isDone) {
                int len = this.tasks.size();
                this.tasks.get(len - 1).toMark();
            }
        }
    }

    public void invoke(String method) throws GaryException {
        switch (method) {
            case "bye":

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

    public void addTodo(String t) {
        tasks.add(new ToDo(t));
        Storage.saveTask(tasks);
    }

    public void addEvent(String e, String date) {
        tasks.add(new Event(e, date));
        Storage.saveTask(tasks);
    }

    public void addDeadline(String d, String date) {
        tasks.add(new Deadlines(d, date));
        Storage.saveTask(tasks);
    }

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
}
