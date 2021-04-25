package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

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

}
