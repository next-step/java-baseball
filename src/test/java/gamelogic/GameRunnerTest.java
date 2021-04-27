package gamelogic;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameRunnerTest {

	private static GameRunner gameRunner;
	private static Method checkAnswerIsTrueMethod;
	private static Method printAndReturnStrikeMethod;
	private static Method printAndReturnBallMethod;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		gameRunner = new GameRunner();

		checkAnswerIsTrueMethod =
			GameRunner.class.getDeclaredMethod("checkAnswerIsTrue", String.class, String.class);
		checkAnswerIsTrueMethod.setAccessible(true);

		printAndReturnStrikeMethod =
			GameRunner.class.getDeclaredMethod("printAndReturnStrike", String.class, String.class);
		printAndReturnStrikeMethod.setAccessible(true);

		printAndReturnBallMethod =
			GameRunner.class.getDeclaredMethod("printAndReturnBall", String.class, String.class, int.class);
		printAndReturnBallMethod.setAccessible(true);
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','123'", "'964','964'", "'528','528'"})
	void checkAnswerIsTrue_InputsAreTrue_True(String answer, String userInput) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)checkAnswerIsTrueMethod.invoke(gameRunner, answer, userInput);
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456'", "'964','649'", "'528','538'"})
	void checkAnswerIsTrue_InputsAreFalse_False(String answer, String userInput) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)checkAnswerIsTrueMethod.invoke(gameRunner, answer, userInput);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456', 0", "'964','694',1", "'528','538',2", "'348','348',3"})
	void PrintAndReturnStrike_ValidInputs_ReturnTrueStrike(String answer, String userInput, int strike) throws
		InvocationTargetException, IllegalAccessException {
		int result = (int)printAndReturnStrikeMethod.invoke(gameRunner, answer, userInput);
		assertThat(result).isEqualTo(strike);
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456', 0, 0", "'964','694', 1, 2", "'528','583', 1, 1", "'348','834', 0, 3"})
	void PrintAndReturnBall_ValidInputs_ReturnTrueBall(String answer, String userInput, int strike, int ball) throws
		InvocationTargetException, IllegalAccessException {
		int result = (int)printAndReturnBallMethod.invoke(gameRunner, answer, userInput, strike);
		assertThat(result).isEqualTo(ball);
	}
}
