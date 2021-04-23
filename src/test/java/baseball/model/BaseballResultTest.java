package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballResultTest {
    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_baseballNumber_builder_generate_number_which_does_not_contain_0(int size, int radix) {
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
        assertThat(baseballResult.getRadix()).isBetween(BaseballNumber.MIN_RADIX, BaseballNumber.MAX_RADIX);
        assertThat(baseballResult.getSize()).isBetween(BaseballNumber.MIN_RADIX - 1, BaseballNumber.MAX_RADIX - 1);

    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test2_baseballNumber_builder_generate_number_which_does_not_contain_0(int size, int radix) {
        BaseballResult baseballResult = BaseballResult.createFailedResult();

        assertThat(baseballResult).isNotNull();
        assertThat(baseballResult.isComplete()).isFalse();
    }
}
