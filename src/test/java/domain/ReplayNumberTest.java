package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReplayNumberTest {

    @ParameterizedTest
    @CsvSource({"1, true", "2, false"})
    @DisplayName("입력받은 숫자에 따라 재시작에 대한 결과를 가져온다.")
    void valueOf(int input, boolean expectedValue) {
        boolean result = ReplayNumber.valueOf(input);

        assertThat(result).isEqualTo(expectedValue);
    }
}
