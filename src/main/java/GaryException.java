import java.lang.Exception;

public class GaryException extends Exception {
    String msg;

    public GaryException(String msg) {
       this.msg = msg;
    }

    public void garyError() {
        System.out.printf("Sorry, what is %s ?\n", this.msg);
    }
}
