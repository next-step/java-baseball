import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import engine.Ball;
import engine.GameEngine;

public class GameEngineTest {
	private GameEngine gameEngine;
	private static final int ANSWER_LENGTH = 3;
	private static final String ANSWER = "123";

	@BeforeEach
	void setUp() {
		gameEngine = new GameEngine(ANSWER, ANSWER_LENGTH);
	}

	@DisplayName("strike 3개일 경우 true를 반환하는지 테스")
	@ParameterizedTest
	@CsvSource(value = {
		"123,true",
		"456,false",
		"243,false",
		"243,false"
	})
	void progressEachStage_WhenCalled_ShouldReturnBoolean(String input, Boolean isStrikeThree) {
		assertThat(gameEngine.progressEachStage(new Ball(input, ANSWER_LENGTH))).isEqualTo(isStrikeThree);
	}

	@DisplayName("정확한 갯수의 strike 갯수를 반환하는지 Test")
	@ParameterizedTest
	@CsvSource(value = {
		"123,3",
		"456,0",
		"243,1",
		"143,2"
	})
	void getStrike_WhenCalled_ShouldReturnInt(String input, int strike) {
		gameEngine.progressEachStage(new Ball(input,ANSWER_LENGTH));
		assertThat(gameEngine.getStrike()).isEqualTo(strike);
	}

	@DisplayName("정확한 갯수의 ball 갯수를 반환하는지 Test")
	@ParameterizedTest
	@CsvSource(value = {
		"123,0",
		"451,1",
		"234,2",
		"312,3"
	})
	void getBall_WhenCalled_ShouldReturnInt(String input, int ball) {
		gameEngine.progressEachStage(new Ball(input,ANSWER_LENGTH));
		assertThat(gameEngine.getBall()).isEqualTo(ball);
	}

	@DisplayName("engine이 reset 잘하는 Test")
	@Test
	void resetGame_WhenCalled_ShouldReturnNewBallLengthWithInt() {
		gameEngine.resetGame();
		assertThat(gameEngine.getAnswer().getBallLength()).isEqualTo(ANSWER_LENGTH);
	}
}
