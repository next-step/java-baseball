package baseball.game.playground;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.ui.impl.TestUiSystem;

class PlayGroundTest {

	TestUiSystem uiSystem = new TestUiSystem();
	PlayGround playGround = new PlayGround();

	@BeforeEach
	void setup() {
		uiSystem = new TestUiSystem();
		playGround = new PlayGround();
	}

	@Test
	@DisplayName("게임 시작을 요청 시 플레이 상태가 된다")
	void should_conditionRunningIsTrue_When_start() {

		// Given
		PlayGround newPlayGround = new PlayGround();

		// When
		newPlayGround.playBall(uiSystem);

		// Then
		assertThat(newPlayGround.isPlaying()).isTrue();

	}

}