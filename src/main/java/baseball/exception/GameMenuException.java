package baseball.exception;

public class GameMenuException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "사용할 수 없는 값입니다. 게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.";

    public GameMenuException() {
        super(ERROR_MESSAGE);
    }
}
