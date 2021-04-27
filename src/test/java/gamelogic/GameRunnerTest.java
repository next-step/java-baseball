package gamelogic;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameRunnerTest {

	private static GameRunner gameRunner;
	private static Method isCorrectInput;
	private static Method checkStrike;
	private static Method checkBall;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		gameRunner = new GameRunner();
		setReflectionForMethod();
	}

	private static void setReflectionForMethod() throws NoSuchMethodException {
		isCorrectInput = GameRunner.class.getDeclaredMethod("isCorrectInput", String.class, String.class);
		isCorrectInput.setAccessible(true);

		checkStrike = GameRunner.class.getDeclaredMethod("checkStrike", String.class, String.class);
		checkStrike.setAccessible(true);

		checkBall = GameRunner.class.getDeclaredMethod("checkBall", String.class, String.class, int.class);
		checkBall.setAccessible(true);
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','123'", "'964','964'", "'528','528'"})
	void isCorrectInput_InputsAreTrue_True(String answer, String userInput) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isCorrectInput.invoke(gameRunner, answer, userInput);
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456'", "'964','649'", "'528','538'"})
	void isCorrectInput_InputsAreFalse_False(String answer, String userInput) throws
		InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isCorrectInput.invoke(gameRunner, answer, userInput);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456', 0", "'964','694',1", "'528','538',2", "'348','348',3"})
	void checkStrike_ValidInputs_ReturnTrueStrike(String answer, String userInput, int strike) throws
		InvocationTargetException, IllegalAccessException {
		int result = (int)checkStrike.invoke(gameRunner, answer, userInput);
		assertThat(result).isEqualTo(strike);
	}

	@ParameterizedTest
	@CsvSource(value = {"'123','456', 0, 0", "'964','694', 1, 2", "'528','583', 1, 1", "'348','834', 0, 3"})
	void checkBall_ValidInputs_ReturnTrueBall(String answer, String userInput, int strike, int ball) throws
		InvocationTargetException, IllegalAccessException {
		int result = (int)checkBall.invoke(gameRunner, answer, userInput, strike);
		assertThat(result).isEqualTo(ball);
	}
}
