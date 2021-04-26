package baseball.game.playground;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.ui.impl.TestUiSystem;

class PlayGroundTest {

	TestUiSystem uiSystem;
	PlayGround playGround;

	@BeforeEach
	void setup() {
		uiSystem = new TestUiSystem();
		playGround = new PlayGround();
	}

	@Test
	@DisplayName("게임 시작 요청 시 플레이 상태가 된다")
	void should_runningIsTrue_When_start() {

		// Given
		uiSystem.setGameInput("123");
		PlayGround newPlayGround = new PlayGround();

		// When
		newPlayGround.playBall(uiSystem);

		// Then
		assertThat(newPlayGround.isPlaying()).isTrue();

	}

}