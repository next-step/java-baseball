package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class inputNumberTest {

    @DisplayName(value = "입력받은 숫자 문자열을 정수 리스트로 변환하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void inputWithoutComma(String input) {
        List<Integer> splitedList = InputNumber.setBallNumber(input);
        assertThat(splitedList).hasSize(3);
        assertThat(splitedList).containsExactly(1,2,3);
    }

    @DisplayName(value = "문자로 잘못 입력한 경우 오류 반환이 되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,a"})
    void inputWithCommaCharater(String input) {
        assertThatThrownBy(() -> {
            InputNumber.setBallNumber(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닙니다");
    }

    @DisplayName(value = "입력받은 숫자 문자열에서 split가 있는 경우 정수 리스트로 변환하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3,5,7"})
    void inputWithComma(String input) {
        List<Integer> splitedList = InputNumber.setBallNumber(input);
        assertThat(splitedList).hasSize(3);
        assertThat(splitedList).containsExactly(3,5,7);
    }

    @DisplayName(value = "입력받은 숫자 문자열에서 split가 있는 경우 정수 리스트로 변환하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1"})
    void inputSameValue(String input) {
        assertThatThrownBy(() -> {
            InputNumber.setBallNumber(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연속 된 세개 수자를 입력하시면 안됩니다");
    }
}
