package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @RepeatedTest(5)
    @DisplayName(
        "Test random number is well generated well" +
        "(Not guarantee in all circumstances)"
    )
    void buildByRandom() {
        assertDoesNotThrow(() -> new Number.Builder().byRandom());
    }

    @Test
    @DisplayName("Test number is well generated with proper input")
    void buildByInt() {
        final int[] digits = {1, 2, 3};

        Number number = assertDoesNotThrow(() -> {
            return new Number.Builder().byInt(123);
        });

        assertArrayEquals(digits, number.getDigits());
    }

    @ParameterizedTest
    @DisplayName("Test exception is well raised with wrong input")
    @ValueSource(ints = {1234, 12, 112, 109})
    void buildByIntWithException(int num) {
        assertThrows(
            Exception.class,
            () -> new Number.Builder().byInt(num)
        );
    }

    @ParameterizedTest
    @DisplayName("Test compare result of two number")
    @CsvSource({
        "456, 0, 0",
        "156, 1, 0",
        "561, 0, 1",
        "142, 1, 1",
    })
    void compareNumber(int num, int expectedStrike, int expectedBall) {
        Number answer = assertDoesNotThrow(() -> {
            return new Number.Builder().byInt(123);
        });

        Number trial = assertDoesNotThrow(() -> {
            return new Number.Builder().byInt(num);
        });

        InningInfo info = answer.compareNumber(trial);
        assertEquals(expectedStrike, info.getStrike());
        assertEquals(expectedBall, info.getBall());
    }
}
