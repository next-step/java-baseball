package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberScannerTest {
    @Test
    @DisplayName("사이즈 3인 리스트 체크")
    public void checkListSizeTest() {
        BaseballNumberScanner numberScanner = new BaseballNumberScanner();
        List<Integer> numberList = numberScanner.makeNumberList("123");
        assertThat(numberList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    @DisplayName("1~9 사이의 수 검증")
    public void validateNumberTest(char input) {
        BaseballNumberScanner numberScanner = new BaseballNumberScanner();
        int number = numberScanner.charToInt(input);
        assertThat(number).isBetween(1,9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"146", "385", "532"})
    @DisplayName("서로 다른 수 검증")
    public void validateUniqueNumberTest(String input) {
        BaseballNumberScanner numberScanner = new BaseballNumberScanner();
        List<Integer> numberList = numberScanner.makeNumberList(input);
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(1));
        assertThat(numberList.get(1)).isNotEqualTo(numberList.get(2));
        assertThat(numberList.get(2)).isNotEqualTo(numberList.get(0));
    }
}
