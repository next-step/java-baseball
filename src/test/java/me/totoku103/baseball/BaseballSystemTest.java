package me.totoku103.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballSystemTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123, 123, true",
            "456, 456, true",
            "957, 957, true",
            "159, 159, true",
            "321, 321, true",
            "312, 321, false",
            "145, 532, false"
    })
    @DisplayName("랜덤 문자열과 사용자 문자열 정확히 맞는지 확인")
    public void checkGameEndTest(String randomString, String userInputString, boolean expectedResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = BaseballSystem.class.getDeclaredMethod("checkGameEnd", String.class);
        method.setAccessible(true);

        final BaseballSystem baseballSystem = new BaseballSystem(randomString);
        final boolean result = (boolean) method.invoke(baseballSystem, userInputString);

        assertThat(result)
                .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123, 123, 3",
            "486, 456, 2",
            "957, 975, 1",
            "159, 628, 0",
            "321, 321, 3",
            "312, 321, 1",
            "145, 532, 0"
    })
    @DisplayName("스트라이크: 위치와 값이 맞는지 확인")
    public void checkCountStrikeTest(String randomString, String userInputString, int expectedStrikeCount) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = BaseballSystem.class.getDeclaredMethod("checkCountStrike", String.class);
        method.setAccessible(true);


        final BaseballSystem baseballSystem = new BaseballSystem(randomString);
        final int result = (int) method.invoke(baseballSystem, userInputString);
        assertThat(result)
                .isEqualTo(expectedStrikeCount);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123, 123, 0",
            "486, 456, 0",
            "957, 795, 3",
            "159, 628, 0",
            "321, 132, 3",
            "312, 321, 2",
            "145, 532, 1"
    })
    @DisplayName("볼: 값은 맞으나 위치가 다른 로직 확인")
    public void checkCountBall(String randomString, String userInputString, int expectedBallCount) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = BaseballSystem.class.getDeclaredMethod("checkCountBall", String.class);
        method.setAccessible(true);


        final BaseballSystem baseballSystem = new BaseballSystem(randomString);
        final int result = (int) method.invoke(baseballSystem, userInputString);
        assertThat(result)
                .isEqualTo(expectedBallCount);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "123, 123, true, 3:STRIKE 0:BALL",
            "486, 456, false, 2:STRIKE 0:BALL",
            "957, 795, false, 0:STRIKE 3:BALL",
            "159, 628, false, 0:STRIKE 0:BALL",
            "321, 132, false, 0:STRIKE 3:BALL",
            "312, 321, false, 1:STRIKE 2:BALL",
            "145, 532, false, 0:STRIKE 1:BALL",
            "126, 128, false, 2:STRIKE 0:BALL",
            "521, 421, false, 2:STRIKE 0:BALL"
    })
    @DisplayName("스트라크 볼 로직 테스트")
    public void validate(String randomString, String userInputString, boolean expectedResult, String consoleMessage) {
        final BaseballSystem baseballSystem = new BaseballSystem(randomString);

        final boolean result = baseballSystem.isGameEnd(userInputString);
        assertThat(result)
                .isEqualTo(expectedResult);

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo(consoleMessage);
    }

}