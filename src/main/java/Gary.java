import java.sql.Array;
import java.util.*;

public class Gary {
    public static void main(String[] args) {

        System.out.println("Hello, i'm Gary! What's on your to do list today?\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        String nxt = sc.nextLine();
        while (!nxt.equals("bye")) {
            if (nxt.equals("list")) {
                for (String str : items) {
                    System.out.println(str);
                }
            }
            items.add(nxt); // store
            nxt = sc.nextLine();
        }
        System.out.println("Bye, hope you stay productive!\n");
    }
}
