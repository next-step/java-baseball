package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @DisplayName("게임 재실행 여부 체크")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false", "a:false", "3:false"}, delimiter = ':')
    void checkRetry(String input, boolean expected) {
        boolean retryValue = Main.checkRetry(input);
        assertEquals(expected, retryValue);
    }
}
