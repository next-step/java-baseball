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

	@ParameterizedTest
	@CsvSource(value = {"123:true", "2345:false", "5435:false", "333:false", "343:false", "teg:false", "zxx:false"}, delimiter = ':')
	@DisplayName("checkRule 메소드 테스트")
	void checkRuleTest(String input, boolean result){
		assertThat(baseballGame.checkRule(input)).isEqualTo(result);
	}

	@Test
	@DisplayName("checkResult 메소드 3strike Test")
	void checkResultStrikeTest(){
		BaseballScore baseballScore = baseballGame.checkResult(baseballGame.getRandomBall());
		assertThat(baseballScore.getMessage()).contains("3스트라이크");
	}

	@Test
	@DisplayName("checkResult 메소드 3Ball Test")
	void checkResultBallTest(){

		String testVal = "" + baseballGame.getRandomBall().charAt(1) + baseballGame.getRandomBall().charAt(2) + baseballGame.getRandomBall().charAt(0);
		BaseballScore baseballScore = baseballGame.checkResult(testVal);
		assertThat(baseballScore.getMessage()).contains("3볼");
	}


	@Test
	@DisplayName("checkResult 메소드 Strike, Ball Test")
	void checkResultStrikeAndBallTest(){

		String testVal = "" + baseballGame.getRandomBall().charAt(0) + baseballGame.getRandomBall().charAt(2) + baseballGame.getRandomBall().charAt(1);
		BaseballScore baseballScore = baseballGame.checkResult(testVal);
		assertThat(baseballScore.getMessage()).contains("1스트라이크2볼");
	}

	@Test
	@DisplayName("BaseBallGame 전체 테스트 ")
	void checkGameTest(){
		GamePlayer gamePlayer = new GamePlayer();
		gamePlayer.playGame();
	}

}
