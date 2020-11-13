package baseball;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public class WrongNumberInputException extends RuntimeException {
	WrongNumberInputException(String message) {
		super(String.format("1~9의 숫자를 3자리 입력해야 하고 모두 값이 달라야 합니다. %s", message));
	}
}
