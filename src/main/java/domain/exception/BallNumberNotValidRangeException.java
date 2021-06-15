package domain.exception;

import static domain.BallNumber.MAX_BALL_NUMBER;
import static domain.BallNumber.MIN_BALL_NUMBER;

public class BallNumberNotValidRangeException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "볼 숫자 생성 시 " + MIN_BALL_NUMBER + "~" + MAX_BALL_NUMBER + " 사이의 숫자만 입력 가능합니다.";

    public BallNumberNotValidRangeException() {
        super(ERROR_MESSAGE);
    }
}
