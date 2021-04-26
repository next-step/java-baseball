package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Game;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InningStateTest {

	Game game;
	InningState inningState;

	@BeforeEach
	void setUp() {
		game = new Game();
		inningState = new InningState(game);
		game.onInningState();
	}

	@DisplayName("3자리 숫자 변환 가능")
	@Test
	void valid() {
		assertThat(inningState.isValid("123")).isTrue();
	}

	@DisplayName("3자리 숫자 변환 불가")
	@ParameterizedTest
	@ValueSource(strings = {"1234", "001", "text", ""})
	void notValid(String str) {
		assertThat(inningState.isValid(str)).isFalse();
	}

	@DisplayName("숫자 입력: 사용자를 생성하고 판정 상태로 간다.")
	@Test
	void guess() {
		assertThat(game.currentState().getClass()).isEqualTo(InningState.class);
		assertThat(game.getPlayer()).isNull();
		inningState.guess("123");
		assertThat(game.getPlayer()).isNotNull();
		assertThat(game.currentState().getClass()).isEqualTo(DecisionState.class);
	}

}
