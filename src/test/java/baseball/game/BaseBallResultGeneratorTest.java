package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallResultGeneratorTest {

    @Test
    @DisplayName("1~9까지 다른 수 3자리 입력 구현")
    void generateResult() {

        String result = BaseBallResultGenerator.generateResult();

        assertTrue(Pattern.matches("^[1-9]{3}$", result));
        assertEquals(3, new HashSet<>(Arrays.asList(result.split(""))).size());
    }
}