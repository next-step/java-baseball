package io.github.sejoung.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

	@DisplayName("게임 초기화시 완료 상태가 아니다")
	@Test
	void isCompletedTest() {
		BaseBallGame game = new BaseBallGame(new BaseBallNumberGeneratorStub(1, 2, 3));
		assertThat(game.isCompleted()).isFalse();
	}
}
