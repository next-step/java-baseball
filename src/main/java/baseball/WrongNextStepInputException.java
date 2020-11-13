package baseball;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class WrongNextStepInputException extends RuntimeException {
	WrongNextStepInputException() {
		super("게임을 새로 시작하려면 1, 종료하려면 2를 입력해야 합니다. 입력한 값을 다시 확인해주세요.");
	}
}
