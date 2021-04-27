package baseball;



import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputOutputTest {
    private static InputOutput io = new InputOutput();

    @DisplayName("입력한 숫자가 정확히 3자리로 된 숫자인지 혹은 정답을 확인하는 숫자인지 학인")
    @ParameterizedTest
    @CsvSource(value = {"abdvs:false", "12345:false", "a34:false", "^^1:false", "9:true", "146:true"}, delimiter = ':')
    void testCheckInputNumber(String input, boolean expected) {
        assertThat(io.checkInputNumber(input)).isEqualTo(expected);
    }
}
