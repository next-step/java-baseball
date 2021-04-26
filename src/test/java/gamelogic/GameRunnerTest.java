package gamelogic;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRunnerTest {

	private static GameRunner game;
	private static Method isValidAnswerMethod;
	private static Method generateAnswerMethod;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		game = new GameRunner();

		isValidAnswerMethod = GameRunner.class.getDeclaredMethod("isValidAnswer", int.class);
		isValidAnswerMethod.setAccessible(true);

		generateAnswerMethod = GameRunner.class.getDeclaredMethod("generateAnswer");
		generateAnswerMethod.setAccessible(true);
	}

	@ParameterizedTest
	@ValueSource(ints = {331, 555, 949})
	void isValidAnswer_SameDigitsInputs_False(int input)
		throws InvocationTargetException, IllegalAccessException {

		boolean result = (boolean)isValidAnswerMethod.invoke(game, input);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {321, 546, 947})
	void isValidAnswer_ValidFormatAnswers_True(int input)
		throws InvocationTargetException, IllegalAccessException {

		boolean result = (boolean)isValidAnswerMethod.invoke(game, input);
		assertThat(result).isTrue();
	}

	@Test
	void generateAnswer_CallCheckIsValidAnswer_True()
		throws InvocationTargetException, IllegalAccessException {
		int generatedAnswer = (int)generateAnswerMethod.invoke(game);
		boolean result = (boolean)isValidAnswerMethod.invoke(game, generatedAnswer);
		assertThat(result).isTrue();
	}
}
