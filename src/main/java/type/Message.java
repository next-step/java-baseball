package type;

import static config.Property.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {

	ENTER_NUMBER("숫자를 입력해 주세요 : "),
	WRONG_NUMBER(NUMBER_SIZE + "자리의 양수로 입력해주세요."),
	WIN_GAME(NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료."),
	ENTER_RETRY_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	RETRY_INPUT("다시 입력해주세요."),
	NOTING("낫싱"),
	;

	private final String printString;

	@Override
	public String toString() {
		return printString;
	}
}
