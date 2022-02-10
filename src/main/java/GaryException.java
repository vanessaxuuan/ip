package gary;
import java.lang.Exception;

/**
 * Represents Exceptions that will be encountered by Gary
 * Invoked by invalid user input
 */
public class GaryException extends Exception {
    String msg;

    public GaryException(String msg) {
       this.msg = msg;
    }

    /**
     * Prints out the invalid input
     */
    public void garyError() {
        System.out.printf("Sorry, what is %s ?\n", this.msg);
    }
}
