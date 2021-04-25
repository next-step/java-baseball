package baseball.game.playground.referee;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

	@Test
	@DisplayName("숫자값을 비교해 판정 객체를 생성 할 수 있다")
	void should_createJudgement_When_judgement_number() {

		// Given
		Referee referee = new Referee();

		// When
		judgement judgement = referee.judgement("123", "123");

		// Then
		assertThat(judgement).isNotNull();
	}

}