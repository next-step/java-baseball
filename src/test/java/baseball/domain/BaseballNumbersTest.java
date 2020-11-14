package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {
    private BaseballNumbers baseballNumbers;

    @BeforeEach
    void setUp() {
        baseballNumbers = new BaseballNumbers(Arrays.asList(
                BaseballNumber.of(1, 1),
                BaseballNumber.of(2, 2),
                BaseballNumber.of(3, 3)
        ));
    }

    @Test
    @DisplayName("숫자 입력을 통한 생성")
    void fromInt() {
        assertThat(BaseballNumbers.from(123)).isEqualTo(baseballNumbers);
    }

    @Test
    @DisplayName("Number 컬렉션 입력을 통한 생성")
    void fromNumbers() {
        List<Number> numbers = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3)
        );
        assertThat(BaseballNumbers.from(numbers)).isEqualTo(baseballNumbers);
    }
}
