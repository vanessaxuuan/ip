package gary;
import java.lang.Exception;

/**
 * Represents Exceptions that will be encountered by Gary
 * Invoked by invalid user input
 */
public class GaryException extends Exception {
    private String msg;

    /**
     * Constructs a new Gary Exception with given message
     *
     * @param msg invalid user input
     */
    public GaryException(String msg) {
       this.msg = msg;
    }

    /**
     * Prints out error message
     */
    public void garyError() {
        System.out.printf("Sorry, what is %s ?\n", this.msg);
    }

    /**
     * Prints out invalid input
     *
     * @return invalid input
     */
    public String getMessage() {
        return msg;
    }
}
