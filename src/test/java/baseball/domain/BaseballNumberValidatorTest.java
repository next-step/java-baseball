package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberValidatorTest {
    private BaseballNumberValidator baseballNumberValidator;

    @BeforeEach
    public void setup() {
        baseballNumberValidator = new BaseballNumberValidator();
    }

    @Test
    @DisplayName("검증할 야구번호가 0을 포함하지 않는 서로 다른 3자리일 경우 true 리턴한다.")
    public void return_true_when_numbers_are_ThreeDigits() {
        List<Integer> baseballNumbers = Arrays.asList(2, 4, 7);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isTrue();
    }

    @Test
    @DisplayName("검증할 야구번호 자리수가 3자리가 아닐 경우 false 리턴한다.")
    public void return_false_when_numbers_are_not_ThreeDigits() {
        List<Integer> baseballNumbers = Arrays.asList(2, 4);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
        baseballNumbers = Arrays.asList(2, 4, 7, 9);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
    }

    @Test
    @DisplayName("검증할 야구번호가 0을 포함한 경우 false 리턴한다.")
    public void return_false_when_numbers_include_zero() {
        List<Integer> baseballNumbers = Arrays.asList(2, 4, 0);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
        baseballNumbers = Arrays.asList(0, 2, 4);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
        baseballNumbers = Arrays.asList(2, 0, 4);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
    }

    @Test
    @DisplayName("검증할 야구번호가 중복 숫자를 포함할 경우 false 리턴한다.")
    public void return_false_when_numbers_are_duplicated() {
        List<Integer> baseballNumbers = Arrays.asList(2, 4, 4);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
        baseballNumbers = Arrays.asList(2, 2, 4);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
        baseballNumbers = Arrays.asList(2, 6, 2);
        assertThat(baseballNumberValidator.isValid(baseballNumbers)).isFalse();
    }
}