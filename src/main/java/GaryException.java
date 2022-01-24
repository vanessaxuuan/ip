public class GaryException extends Exception {
    // represent exceptions specific to Gary
    // int err;
    String msg;

    public GaryException(String msg) {
       // this.err = err;
       this.msg = msg;
    }

    public void GaryError() {
        System.out.printf("Sorry, what is %s ?\n", this.msg);
    }
}
