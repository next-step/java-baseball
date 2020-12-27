package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberScannerTest {

    private final NumberScanner numberScanner = new NumberScanner();

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3"})
    @DisplayName("char이 int로 잘 변환되는지 테스트")
    public void charToIntTest(char input, int expected) {
        assertThat(numberScanner.charToInt(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("String을 set으로 변환한다")
    public void makeListTest() {
        List<Integer> numbers = numberScanner.makeList("431");
        assertThat(numbers).containsExactly(4, 3, 1);
    }

    @Test
    @DisplayName("중복된 숫자가 있을 시 에러를 반환한다")
    public void RedundantInputTest() {
        assertThatThrownBy(() -> numberScanner.makeList("443"))
                .hasMessageContaining("입력값이 잘못되었습니다.");
    }

    @Test
    @DisplayName("입력값이 3개가 아닌 경우 에러를 반환한다")
    public void Not3InputTest() {
        assertThatThrownBy(() -> numberScanner.makeList("1234"))
                .hasMessageContaining("입력값이 잘못되었습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 있을 시 에러를 반환한다.")
    public void NonNumericInputTest() {
        assertThatThrownBy(() -> numberScanner.makeList("d33"))
                .hasMessageContaining("입력값이 잘못되었습니다.");
    }
}
