package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class baseballGameTest {

	BaseballGame baseballGame;
	String balls;

	@BeforeEach
	void setUp(){
		baseballGame = new BaseballGame();
		balls = baseballGame.getRandomBall();
	}

	@Test
	@DisplayName("3자리수 인지 나오는지 테스트")
	void baseballGameLengthTest(){
		assertThat(baseballGame.getRandomBall().length()).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:1", "0:2", "1:2"}, delimiter = ':')
	@DisplayName("3자리 숫자 중복 테스트 ")
	void baseballGameOverlapTest(int first, int second){
		assertThat(balls.charAt(first) == balls.charAt(second)).isEqualTo(false);
	}
}
