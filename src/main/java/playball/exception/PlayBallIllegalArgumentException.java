package playball.exception;

public class PlayBallIllegalArgumentException extends IllegalArgumentException {

    public PlayBallIllegalArgumentException() {
    }

    public PlayBallIllegalArgumentException(String s) {
        super(s);
    }

    public PlayBallIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayBallIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
