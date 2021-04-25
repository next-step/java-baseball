package baseball.game.playground.hitter;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.game.playground.gameball.GameBall;

class HitterTest {

	@Test
	@DisplayName("타자 생성시 전달받은 임의의 번호를 swing을 통해 표현할수 있다")
	void should_hasRandomNumber_When_create() {

		// Given
		GameBall gameBall = GameBall.create();
		Hitter hitter = new Hitter(gameBall);

		// When
		String hitterNumber = hitter.swing();

		// Then
		assertThat(hitterNumber).isEqualTo(gameBall.toString());
	}

}