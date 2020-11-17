package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"120, false", "2021, false", "312, true", "459, true", "590, false", "12, false"})
    @DisplayName("사용자의 입력값에 대한 유효성을 검증한다.")
    public void testValidInput(int expectedValue, boolean expectedResult) {
        assertThat(validInput(expectedValue)).isEqualTo(expectedResult);
    }

    private boolean validInput(int input) {
        if ((input >= 111 && input <= 999) && Pattern.matches("^[1-9]*$", Integer.toString(input))) {
            return true;
        }
        return false;
    }
}
