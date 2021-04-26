package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import baseball.util.random.RandomBaseballNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BaseballNumberTest {
    @ParameterizedTest(name =  "BaseballNumber.builder().size(size).raid(radix).build() [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_1_baseballNumber_builder_generate_number(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).build();

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().size(size).raid(radix).addAll().build() [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_2_baseballNumber_builder_generate_number(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).addAll().build();

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().size(size).raid(radix).addRandomNumber(size).build() [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_3_baseballNumber_builder_generate_number(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).addRandomNumber(size).build();

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().size(size).raid(radix).random(r->...).build() [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test1_4_baseballNumber_builder_generate_number(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).random(r -> new Random().nextInt(r)).build();

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "new RandomBaseballNumberGenerator().generateRandomBaseballNumber(size, radix) [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    public void test2_1_RandomBaseballNumberGenerator_can_generate_random_number(int size, int radix) {
        BaseballNumber baseballNumber =new RandomBaseballNumberGenerator().generateRandomBaseballNumber(size, radix);

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "new RandomBaseballNumberGenerator().generateRandomBaseballNumber(size, radix) [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    public void test2_2_RandomBaseballNumberGenerator_exception_case(int size, int radix) {
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> new RandomBaseballNumberGenerator().generateRandomBaseballNumber(size, radix));
    }

    @ParameterizedTest(name = "new BaseballNumber(input, size, radix) [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]" )
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideRandomBaseballNumberOfAllSizeAndAllRadix"
    })
    public void test3_1_baseballNumber_constructor_generate_number(String input, int size, int radix) {
        BaseballNumber baseballNumber = new BaseballNumber(input, size, radix);

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "new BaseballNumber(input) [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideRandomBaseballNumberOfDefaultSizeAndDefaultRadix"
    })
    public void test3_2_baseballNumber_constructor_generate_number(String input) {
        BaseballNumber baseballNumber = new BaseballNumber(input);

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "new BaseballNumber(input, size, radix) [" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER + "]")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideRandomBaseballRadixOutBoundExceptionCase",
            "baseball.model.TestParametersProvider#provideRandomBaseballContainsZeroExceptionCase",
            "baseball.model.TestParametersProvider#provideRandomBaseballDuplicatedExceptionCase",
            "baseball.model.TestParametersProvider#provideRandomBaseballNotValidCharacterExceptionCase",
    })
    public void test3_3_baseballNumber_constructor_exception(String input, int size, int radix) {
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> new BaseballNumber(input, size, radix));
    }

    private void checkBaseballNumber(BaseballNumber baseballNumber) {
        int[] numbers = baseballNumber.getNumbers();

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        assertThat(set).doesNotContain(0);
        assertThat(set).hasSize(numbers.length);
        assertThat(baseballNumber).asString().hasSize(numbers.length);
        assertThat(baseballNumber.getSize()).isEqualTo(numbers.length);
    }
}
