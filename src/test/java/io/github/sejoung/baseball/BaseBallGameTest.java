package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

	private final static String NEW_LINE = System.lineSeparator();

	@DisplayName("게임 초기화시 완료 상태가 아니다")
	@Test
	void initialized_isCompletedTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		assertThat(game.isCompleted()).isFalse();
	}

	@DisplayName("게임 실행시 숫자를 입력해주세요 메시지 출력")
	@Test
	void print_inputMessage() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		String actual = game.flushOutput();

		assertThat(actual).isEqualTo("숫자를 입력해주세요: ");
	}

	@DisplayName("플레이어가 입력한 값은 3자리 이다.")
	@Test
	void playerInputNumberValidtion() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		game.flushOutput();
		game.processInput("12");
		String actual = game.flushOutput();
		assertThat(actual).isEqualTo("3 자리수만 입력 가능합니다." + NEW_LINE + "숫자를 입력해주세요: ");

	}
}
