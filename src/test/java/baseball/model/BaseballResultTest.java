package baseball.model;

import baseball.constants.BaseballConstant;
import baseball.exception.BaseballNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BaseballResultTest {
    @DisplayName(value = "BaseballResult calcResult Test_1_1 Success Case")
    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix"
    })
    public void test1_1_BaseballResult_calcResult(int size, int radix) {
        BaseballNumber left = BaseballNumber.builder().size(size).radix(radix).build();
        BaseballNumber right = BaseballNumber.builder().size(size).radix(radix).build();
        BaseballResult baseballResult = BaseballResult.calcResult(left, right);

        assertThat(left.getSize()).isEqualTo(right.getSize());
        assertThat(baseballResult).isNotNull();
        assertThat(baseballResult.toString()).isNotNull().hasSizeGreaterThan(1);
        assertThat(baseballResult.description()).isNotNull();
        assertThat(baseballResult.getBaseballNumbers()).hasSize(2);
        assertThat(baseballResult.getStrike()).isBetween(0, left.getSize());
        assertThat(baseballResult.getBall()).isBetween(0, left.getSize());
        assertThat(baseballResult.getRadix()).isBetween(BaseballConstant.MIN_RADIX, BaseballConstant.MAX_RADIX);
        assertThat(baseballResult.getSize()).isBetween(BaseballConstant.MIN_SIZE, BaseballConstant.MAX_SIZE);
    }

    @DisplayName(value = "BaseballResult calcResult Test_1_2 Exception Case")
    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_2_BaseballResult_calcResult_exception_case(int size, int radix) {
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> {
            BaseballNumber left = BaseballNumber.builder().size(size).radix(radix).build();
            BaseballNumber right = BaseballNumber.builder().size(size).radix(radix).build();
            BaseballResult.calcResult(left, right);
        });
    }

    @DisplayName(value = "BaseballResult create failed result Test_2 Success Case")
    @Test
    public void test2_BaseballResult_create_failed_result() {
        BaseballResult baseballResult = BaseballResult.createFailedResult();

        assertThat(baseballResult).isNotNull();
        assertThat(baseballResult.isComplete()).isFalse();
    }
}
