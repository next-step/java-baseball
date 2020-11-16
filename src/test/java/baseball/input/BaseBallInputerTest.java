package baseball.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseBallInputerTest {

    @DisplayName("정상적인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"123", "954"})
    void input(String input) {
        String inputValue = BaseBallInputer.input(new ByteArrayInputStream(input.getBytes()));

        assertEquals(3, inputValue.length());
    }

    @DisplayName("비정상적인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1a3", "95", "11223"})
    void Exception_input(String input) {
        assertThrows(IllegalArgumentException.class, () -> BaseBallInputer.input(new ByteArrayInputStream(input.getBytes())));
    }


}