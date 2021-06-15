package domain.exception;

public class BallsDuplicatedPositionException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "중복된 위치의 볼이 존재합니다.";

    public BallsDuplicatedPositionException() {
        super(ERROR_MESSAGE);
    }
}
