package gamelogic;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameAnswerGeneratorTest {

	private static GameAnswerGenerator gameAnswerGenerator;
	private static Method isValidAnswer;

	@BeforeAll
	public static void beforeAll() throws NoSuchMethodException {
		gameAnswerGenerator = new GameAnswerGenerator();
		setReflectionForMethod();
	}

	private static void setReflectionForMethod() throws NoSuchMethodException {
		isValidAnswer = GameAnswerGenerator.class.getDeclaredMethod("isValidAnswer", int.class);
		isValidAnswer.setAccessible(true);
	}

	@ParameterizedTest
	@ValueSource(ints = {331, 555, 949})
	void isValidAnswer_withSameDigits_False(int input)
		throws InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isValidAnswer.invoke(gameAnswerGenerator, input);
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {321, 546, 947})
	void isValidAnswer_withValidAnswerFormat_True(int input)
		throws InvocationTargetException, IllegalAccessException {
		boolean result = (boolean)isValidAnswer.invoke(gameAnswerGenerator, input);
		assertThat(result).isTrue();
	}
}
