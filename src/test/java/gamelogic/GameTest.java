package gamelogic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static Game game;
    private static Method isValidAnswerMethod;
    private static Method generateAnswerMethod;
    @BeforeAll
    public static void beforeAll() throws NoSuchMethodException {
        game = new Game();

        isValidAnswerMethod = Game.class.getDeclaredMethod("isValidAnswer", int.class);
        isValidAnswerMethod.setAccessible(true);

        generateAnswerMethod = Game.class.getDeclaredMethod("generateAnswer");
        generateAnswerMethod.setAccessible(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {331, 555, 949})
    void isValidAnswer_withSameDigits_False(int input)
            throws InvocationTargetException, IllegalAccessException {

        boolean result = (boolean) isValidAnswerMethod.invoke(game, input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {321, 546, 947})
    void isValidAnswer_withValidAnswerFormat_True(int input)
            throws InvocationTargetException, IllegalAccessException {

        boolean result = (boolean) isValidAnswerMethod.invoke(game, input);
        assertThat(result).isTrue();
    }

    @Test
    void generateAnswer_checkIsValidAnswer_True()
            throws InvocationTargetException, IllegalAccessException {
        int generatedAnswer = (int) generateAnswerMethod.invoke(game);
        boolean result = (boolean) isValidAnswerMethod.invoke(game, generatedAnswer);
        assertThat(result).isTrue();
    }
}
