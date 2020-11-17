package baseball.exception;

/**
 * 중복된 야구 숫자에 대한 예외
 *
 * @author  Yonggu Han
 */
public class DuplicatedNumbersException extends IncorrectNumbersException {

    public DuplicatedNumbersException() {
        super("잘못된 숫자 형식입니다.");
    }

    public DuplicatedNumbersException(String message) {
        super(message);
    }
}
