import java.sql.Array;
import java.util.*;

public class Gary {
    public static void main(String[] args) {

        System.out.println("Hello, i'm Gary! What's on your to do list today?\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> items = new ArrayList<>();
        String nxt = sc.nextLine();

        while (!nxt.equals("bye")) {
            if (nxt.equals("list")) {
                Gary.printList(1, items);

            } else if (nxt.equals("mark")) {
                System.out.println("which tasks have you completed? e.g. 2 3");
                String nums = sc.nextLine();
                String[] first = nums.split(" ");
                int i = 0;
                for(String str : first) {
                    items.get(Integer.parseInt(first[i]) - 1).toMark();
                    i++;
                }
                Gary.printList(2, items);

            } else if (nxt.equals("unmark")) {
                System.out.println("made some mistakes?");
                String nums = sc.nextLine();
                String[] first = nums.split(" ");
                int k = 0;
                for(String str : first) {
                    items.get(Integer.parseInt(first[k]) - 1).toUnmark();
                    k++;
                }

            } else {
                String[] type = nxt.split(" ", 5);
                String theTask = type[0];

                switch(theTask) {
                    case "todo" :
                      items.add(new ToDo(type[1]));
                      break;
                    case "event" :
                        String[] e = nxt.split("/", 5);
                        items.add(new Event(e[0].substring(6), e[1]));
                        break;
                    case "deadline" :
                        String[] d = nxt.split("/", 5);
                        items.add(new Deadlines(d[0].substring(9), d[1]));
                        break;
                    default:
                        System.out.println("please enter a valid task e.g. task_type name / date");
                        break;
                }
            }
            nxt = sc.nextLine(); // continue getting inputs
        }
        System.out.println("Bye, hope you stay productive!\n");
    }

    public static void printList(int type, ArrayList<Task> item) {
        if(type == 1) {
            System.out.println("Tasks:");
        } else {
            System.out.println("Alright, this is your updated to do list");
        }
        int j = 1;
        for (Task str : item) {
            System.out.printf("%d. %s\n", j, str);
            j++;
        }
    }
}
