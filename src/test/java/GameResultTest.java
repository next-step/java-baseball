import java.util.function.BiFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import constant.GameRules;
import dto.GameResult;
import util.GameManager;

@DisplayName("사용자의 입력에 따른 결과 테스트")
public class GameResultTest {
	private String answer;
	private String userNumber;
	private final GameManager gameManager = new GameManager();

	@DisplayName("스트라이크 갯수 체크 테스트")
	@Test
	public void isRightStrikeCntTest() {
		BiFunction<String, String, Integer> strike = GameRules.Strike.getApply();
		answer = "123";
		userNumber = "146";
		Assertions.assertEquals(1, strike.apply(answer, userNumber));
		answer = "234";
		userNumber = "345";
		Assertions.assertEquals(0, strike.apply(answer, userNumber));
	}

	@DisplayName("볼 갯수 체크 테스트")
	@Test
	public void isRightBallCntTest() {
		BiFunction<String, String, Integer> ball = GameRules.Ball.getApply();
		answer = "123";
		userNumber = "256";
		Assertions.assertEquals(1, ball.apply(answer, userNumber));
		answer = "125";
		userNumber = "256";
		Assertions.assertEquals(2, ball.apply(answer, userNumber));
		answer = "123";
		userNumber = "312";
		Assertions.assertEquals(3, ball.apply(answer, userNumber));
	}

	@DisplayName("정답 출력 테스트")
	@Test
	public void printAnswerTest() {
		answer = "123";
		userNumber = "123";
		GameResult gameResult = gameManager.checkResult(answer, userNumber);
		Assertions.assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", gameResult.getMsg());
		Assertions.assertTrue(gameResult.getSuccessFlag());
	}

	@DisplayName("스트라이크, 볼 출력 테스트")
	@Test
	public void printStrikeAndBallTest() {
		answer = "123";
		userNumber = "145";
		GameResult gameResult = gameManager.checkResult(answer, userNumber);
		Assertions.assertEquals("1 스트라이크", gameResult.getMsg());

		answer = "123";
		userNumber = "245";
		gameResult = gameManager.checkResult(answer, userNumber);
		Assertions.assertEquals("1 볼", gameResult.getMsg());

		answer = "123";
		userNumber = "132";
		gameResult = gameManager.checkResult(answer, userNumber);
		Assertions.assertEquals("1 스트라이크 2 볼", gameResult.getMsg());
	}

	@DisplayName("낫싱 출력 테스트")
	@Test
	public void printNothingTest() {
		answer = "123";
		userNumber = "456";
		GameResult gameResult = gameManager.checkResult(answer, userNumber);
		Assertions.assertEquals("낫싱", gameResult.getMsg());
	}
}
