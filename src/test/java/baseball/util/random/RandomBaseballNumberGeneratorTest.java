package baseball.util.random;

import baseball.exception.BaseballNumberFormatException;
import baseball.model.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
public class RandomBaseballNumberGeneratorTest {

    @DisplayName(value = "Default RandomNumberGenerator Test_1_1 Success Case")
    @ParameterizedTest(name = "RandomNumberGenerator.getDefault().generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideRadix"
    })
    public void test1_1_Default_RandomNumberGenerator_generate_random_number(int radix) {
        RandomNumberGenerator rng = RandomNumberGenerator.getDefault();
        int randomNumber = rng.generateRandomNumber(radix);

        assertThat(randomNumber).isBetween(0, radix - 1);
    }

    @DisplayName(value = "Default RandomNumberGenerator Test_1_2 Exception Case")
    @ParameterizedTest(name = "RandomNumberGenerator.getDefault().generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    public void test1_2_Default_RandomNumberGenerator_generate_random_number_exception_case(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator(i -> (int)(Math.random() * i));
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> rng.generateRandomBaseballNumber(size, radix));
    }

    @DisplayName(value = "Custom RandomNumberGenerator Test_2_1 Success Case")
    @ParameterizedTest(name = "new RandomNumberGenerator(...).generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
    })
    public void test2_1_Custom_RandomNumberGenerator_generate_random_number(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator(i -> (int)(Math.random() * i));
        BaseballNumber randomNumber = rng.generateRandomBaseballNumber(size, radix);

        checkBaseballNumber(randomNumber);
    }

    @DisplayName(value = "Custom RandomNumberGenerator Test_2_2 Exception Case")
    @ParameterizedTest(name = "new RandomNumberGenerator(...).generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    public void test2_2_Custom_RandomNumberGenerator_generate_random_number_exception_case(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator(i -> (int)(Math.random() * i));
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> rng.generateRandomBaseballNumber(size, radix));
    }

    @DisplayName(value = "Default RandomNumberGenerator Test_3_1 Success Case")
    @ParameterizedTest(name = "new RandomNumberGenerator().generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
    })
    public void test3_1_Default_RandomNumberGenerator_generate_random_number(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator();
        BaseballNumber baseballNumber = rng.generateRandomBaseballNumber(size, radix);
        checkBaseballNumber(baseballNumber);
    }

    @DisplayName(value = "Default RandomNumberGenerator Test_3_2 Exception Case")
    @ParameterizedTest(name = "new RandomNumberGenerator().generateRandomNumber("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+")")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix",
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    public void test3_2_Default_RandomNumberGenerator_generate_random_number_exception_case(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator();
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> rng.generateRandomBaseballNumber(size, radix));
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
