package domain.exception;

import static domain.BallNumber.MAX_BALL_NUMBER;
import static domain.BallNumber.MIN_BALL_NUMBER;

public class BallsDuplicatedNumberException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "중복된 숫자의 볼이 존재합니다.";

    public BallsDuplicatedNumberException() {
        super(ERROR_MESSAGE);
    }
}
