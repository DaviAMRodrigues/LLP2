public class LinhaIncorreta extends Exception {
    public LinhaIncorreta() {
        super();
    }

    public LinhaIncorreta(String message) {
        super(message);
    }

    public LinhaIncorreta(String message, Throwable cause) {
        super(message, cause);
    }

    public LinhaIncorreta(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "Linha Incorreta: " + getMessage();
    }

}
