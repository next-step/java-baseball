package gamelogic;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;

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
}
