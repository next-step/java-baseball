package baseball.game.playground.referee;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.ui.impl.TestUiSystem;

class judgementTest {

	private TestUiSystem uiSystem = new TestUiSystem();

	@Test
	@DisplayName("두 숫자를 사용하여 판정 데이터를 생성한다")
	void should_success_When_createJudgement() {

		// Given
		String pitcherNum = "123";
		String hitterNum = "123";

		// When
		judgement judgement = new judgement(pitcherNum, hitterNum);

		// Then
		assertThat(judgement).isNotNull();
	}

	@ParameterizedTest
	@DisplayName("값을 비교하여 게임 종료 판정을 진행한다")
	@CsvSource(value = {"123:true", "124:false"}, delimiter = ':')
	void should_gameOver_When_judgement(String hitterNum, boolean gameOver) {

		// Given
		String pitcherNum = "123";

		// When
		judgement judgement = new judgement(pitcherNum, hitterNum);

		// Then
		assertThat(judgement.isGameOver()).isEqualTo(gameOver);
	}

	@Test
	@DisplayName("두 숫자가 동일하지 않은 경우 게임오버가 아닌 상태로 판정한다")
	void should_notGameOver_When_notThreeStrike() {

		// Given
		String pitcherNum = "123";
		String hitterNum = "124";

		// When
		judgement judgement = new judgement(pitcherNum, hitterNum);

		// Then
		assertThat(judgement.isGameOver()).isFalse();
	}

	@ParameterizedTest
	@DisplayName("판정에 따라 스트라이크, 볼을 구분할 수 있다")
	@CsvSource(value = {"123:3 스트라이크", "124:2 스트라이크", "145:1 스트라이크",
		"312:3 볼", "345:1 볼, 315:2볼", "678:낫싱"}, delimiter = ':')
	void should_hasScoringData_When_judgement(String hitterNum, String message) {

		// Given
		String pitcherNum = "123";

		// When
		judgement judgement = new judgement(pitcherNum, hitterNum);
		judgement.display(uiSystem);

		// Then
		assertThat(message).contains(uiSystem.getDisplayData());
	}

}