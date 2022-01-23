import java.util.*;

public class Gary {
    public static void main(String[] args) {

        System.out.println("Hello, i'm Gary! What can I do for you?\n");
        Scanner sc = new Scanner(System.in);
        String nxt = sc.nextLine();
        while(!nxt.equals("bye")) {
            System.out.println(nxt); // echo
            nxt = sc.nextLine();
        }
        System.out.println("Bye, have a nice day!\n");
    }
}
