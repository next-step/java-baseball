package baseball.core;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.code.ScoreCode;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseballCoreTest {

	private BaseballCore core;
	private Field fieldNumbersForReset;
	private Field fieldNumbersForGame;
	private Field fieldIsEndGame;
	private Method makeGame;
	private Method countBall;
	private Method countStrike;
	private Method finalScore;

	@BeforeEach
	@SuppressWarnings("unchecked")
	void setUp() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
		// 대조군
		this.core = new BaseballCore();

		// fields
		this.fieldNumbersForReset = this.core.getClass().getDeclaredField("numbersForReset");
		this.fieldNumbersForReset.setAccessible(true);
		this.fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		this.fieldNumbersForGame.setAccessible(true);
		this.fieldIsEndGame = this.core.getClass().getDeclaredField("isEndGame");
		this.fieldIsEndGame.setAccessible(true);

		// methods
		this.makeGame = this.core.getClass().getDeclaredMethod("makeGame");
		this.makeGame.setAccessible(true);
		this.countBall = this.core.getClass().getDeclaredMethod("countBall", String.class);
		this.countBall.setAccessible(true);
		this.countStrike = this.core.getClass().getDeclaredMethod("countStrike", String.class);
		this.countStrike.setAccessible(true);
		this.finalScore = this.core.getClass().getDeclaredMethod("finalScore", String.class);
		this.finalScore.setAccessible(true);
	}

	@Test
	@Order(1)
	@DisplayName(value = "1. 컴퓨터가 게임 생성 여부 확인")
	public void testMakeGame() throws InvocationTargetException, IllegalAccessException {
		// 비교군
		int size = 3;
		Set<Character> numbersForReset = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
		List<Character> numbersForGame = Lists.newArrayList('1', '2', '3');

		// 실행 (5회 반복)
		// 낮은 확률로 numbersForGameInInstance(List<String>)이 "1","2","3"이 순서대로 들어가서 오류를 발생할 수도 있다.
		for (int i = 0; i < 5; i++) {
			this.makeGame.invoke(this.core);

			Set<Character> numbersForResetInInstance = (Set<Character>) this.fieldNumbersForReset.get(this.core);
			List<Character> numbersForGameInInstance = (List<Character>) this.fieldNumbersForGame.get(this.core);

			System.out.println(numbersForResetInInstance);
			System.out.println(numbersForGameInInstance);

			assertThat(numbersForResetInInstance.containsAll(numbersForReset)).isEqualTo(true);
			assertThat(numbersForGameInInstance.containsAll(numbersForGame)).isEqualTo(false);
			assertThat(numbersForGameInInstance.size()).isEqualTo(3);
		}
	}

	@DisplayName(value = "2. Ball Count")
	@ParameterizedTest(name = "{index} - {0} : playerInputs. {1} : expected balls.")
	@Order(2)
	@CsvSource(value = {"123,456,789;1,2,0", "147,258,369;1,1,1", "987,624,351;0,3,0"}, delimiter = ';')
	public void testCountBall(String playerInputs, String expectedScores) throws
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('6', '2', '4');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + fieldNumbersForGame.get(this.core));

		String[] playerInputsArr = playerInputs.split(",");
		String[] expectedScoreArr = expectedScores.split(",");

		System.out.print("playerInputsArr : [");
		for (String input : playerInputsArr) {
			System.out.print(input + " ");
		}
		System.out.println("]");

		System.out.print("expectedScoreArr : [");
		for (String score : expectedScoreArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		for (int i = 0; i < playerInputsArr.length; i++) {
			int ballCnt = (int) countBall.invoke(this.core, playerInputsArr[i]);

			assertThat(ballCnt).isEqualTo(Integer.parseInt(expectedScoreArr[i]));
		}
	}

	@DisplayName(value = "3. Strike Count")
	@ParameterizedTest(name = "{index} - {0} : playerInputs. {1} : expected strikes.")
	@Order(3)
	@CsvSource(value = {"143,256,789;0,2,0", "147,258,369;0,3,0", "987,624,351;0,0,1"}, delimiter = ';')
	public void testCountStrike(String playerInputs, String expectedScores) throws
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('2', '5', '8');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + fieldNumbersForGame.get(this.core));

		String[] playerInputsArr = playerInputs.split(",");
		String[] expectedScoreArr = expectedScores.split(",");

		System.out.print("playerInputsArr : [");
		for (String input : playerInputsArr) {
			System.out.print(input + " ");
		}
		System.out.println("]");

		System.out.print("expectedScoreArr : [");
		for (String score : expectedScoreArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		for (int i = 0; i < playerInputsArr.length; i++) {
			int strikeCnt = (int) countStrike.invoke(this.core, playerInputsArr[i]);

			assertThat(strikeCnt).isEqualTo(Integer.parseInt(expectedScoreArr[i]));
		}
	}

	@DisplayName(value = "4. Final Score")
	@ParameterizedTest(name = "{index} - {0} : playerInputs. {1} : expected strikes. {2} : expected balls.")
	@Order(4)
	@CsvSource(value = {"142,182,582;0,0,0;1,2,3", "148,428,852;1,1,1;0,1,2", "147,258;0,3;0,0"}, delimiter = ';')
	public void testFinalScore(String playerInputs, String expectedStrikeScores, String expectedBallScores) throws
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('2', '5', '8');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + fieldNumbersForGame.get(this.core));

		String[] playerInputsArr = playerInputs.split(",");
		String[] expectedStrikeScoresArr = expectedStrikeScores.split(",");
		String[] expectedBallScoresArr = expectedBallScores.split(",");

		System.out.print("playerInputsArr : [");
		for (String input : playerInputsArr) {
			System.out.print(input + " ");
		}
		System.out.println("]");

		System.out.print("expectedStrikeScoresArr : [");
		for (String score : expectedStrikeScoresArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		System.out.print("expectedBallScoresArr : [");
		for (String score : expectedBallScoresArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		for (int i = 0; i < playerInputsArr.length; i++) {
			ScoreCode scoreCode = (ScoreCode) finalScore.invoke(this.core, playerInputsArr[i]);

			Field strikeField = scoreCode.getClass().getDeclaredField("strike");
			strikeField.setAccessible(true);

			Field ballField = scoreCode.getClass().getDeclaredField("ball");
			ballField.setAccessible(true);

			assertThat(strikeField.get(scoreCode)).isEqualTo(Integer.parseInt(expectedStrikeScoresArr[i]));
			assertThat(ballField.get(scoreCode)).isEqualTo(Integer.parseInt(expectedBallScoresArr[i]));
		}
	}

	@DisplayName(value = "5. Reset Game when start new game.")
	@ParameterizedTest(name = "{index} - {0} : isEndGame. {1} : same previous game.")
	@Order(5)
	@CsvSource(value = {"false;true", "true;false"}, delimiter = ';')
	public void testResetGameWhenNewGame(boolean isEndGame, boolean isSamePrevGame) throws
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('2', '5', '8');
		List<Character> cloneNumbersForGame = Lists.newArrayList('2', '5', '8');

		Field fieldIsEndGame = this.core.getClass().getDeclaredField("isEndGame");
		fieldIsEndGame.setAccessible(true);
		fieldIsEndGame.set(this.core, isEndGame);
		System.out.println("isEndGameInInstance : " + fieldIsEndGame.get(this.core));

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + fieldNumbersForGame.get(this.core));

		System.out.println("isEndGame : " + isEndGame);
		System.out.println("isSamePrevGame : " + isSamePrevGame);


		this.core.resetGameWhenNewGame();

		List<Character> numbersForGameInInstance = (List<Character>) this.fieldNumbersForGame.get(this.core);
		System.out.println("isEndGameInInstance : " + numbersForGameInInstance);

		assertThat(numbersForGameInInstance.containsAll(cloneNumbersForGame)).isEqualTo(isSamePrevGame);
	}

	@DisplayName(value = "6. Reset Game when start new game.")
	@ParameterizedTest(name = "{index} - {0} : player input. {1} : expected result.")
	@Order(6)
	@CsvSource(value = {"123;false", "258;true"}, delimiter = ';')
	public void testCheckWinGame(String playerInput, boolean expectedResult) throws
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('2', '5', '8');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + fieldNumbersForGame.get(this.core));

		System.out.println("playerInput : " + playerInput);
		System.out.println("expectedResult : " + expectedResult);


		boolean actualResult = this.core.checkWinGame(playerInput);

		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
