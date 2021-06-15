package domain.exception;

import static domain.BallNumber.MAX_BALL_NUMBER;
import static domain.BallNumber.MIN_BALL_NUMBER;
import static domain.BallPosition.MAX_BALL_POSITION;
import static domain.BallPosition.MIN_BALL_POSITION;

public class BallPositionNotValidRangeException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "볼 위치 생성 시 " + MIN_BALL_POSITION + "~" + MAX_BALL_POSITION + " 사이의 숫자만 입력 가능합니다.";

    public BallPositionNotValidRangeException() {
        super(ERROR_MESSAGE);
    }
}
