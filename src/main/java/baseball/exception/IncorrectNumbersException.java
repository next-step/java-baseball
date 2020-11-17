package baseball.exception;

/**
 * 잘못된 야구 숫자에 대한 예외
 *
 * @author  Yonggu Han
 */
public class IncorrectNumbersException extends RuntimeException {

    public IncorrectNumbersException() {
        super("잘못된 숫자 형식입니다.");
    }

    public IncorrectNumbersException(String message) {
        super(message);
    }
}
