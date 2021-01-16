package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @RepeatedTest(5)
    @DisplayName(
        "Test random number is well generated well" +
        "(Not guarantee in all circumstances)"
    )
    void builderRandom() {
        assertDoesNotThrow(() -> new Number.Builder().Random());
    }
}