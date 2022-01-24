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
                System.out.println("To do list:");
                int j = 1;
                for (Task str : items) {
                    System.out.printf("%d. %s\n", j, str);
                    j++;
                }
            } else if (nxt.equals("mark")) {
                System.out.println("which tasks have you completed?");
                String nums = sc.nextLine();
                String[] first = nums.split(" ");
                int i = 0;
                for(String str : first) {
                    items.get(Integer.parseInt(first[i]) - 1).toMark();
                    i++;
                }
                System.out.println("Alright, this is your updated to do list");
                int j = 1;
                for (Task str : items) {
                    System.out.printf("%d. %s\n", j, str);
                    j++;
                }

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
                items.add(new Task(nxt)); // store
            }
            nxt = sc.nextLine(); // continue getting inputs
        }
        System.out.println("Bye, hope you stay productive!\n");
    }
}
