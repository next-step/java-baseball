package baseball.util.random;

import baseball.exception.BaseballNumberFormatException;
import baseball.model.BaseballNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
public class RandomBaseballNumberGeneratorTest {

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideRadix"
    })
    void test1_1(int radix) {
        RandomNumberGenerator rng = RandomNumberGenerator.getDefault();
        int randomNumber = rng.generateRandomNumber(radix);

        assertThat(randomNumber).isBetween(0, radix - 1);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    void test2_1(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator(i -> (int)(Math.random() * i));
        BaseballNumber randomNumber = rng.generateRandomBaseballNumber(size, radix);

        checkBaseballNumber(randomNumber);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    void test2_2(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator(i -> (int)(Math.random() * i));
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> rng.generateRandomBaseballNumber(size, radix));
    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideSizeAndRadix",
            "baseball.model.TestParametersProvider#provideTooMuchSizeOrTooMuchRadix"
    })
    void test3_1(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator();
        BaseballNumber baseballNumber = rng.generateRandomBaseballNumber(size, radix);

        checkBaseballNumber(baseballNumber);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {
            "baseball.model.TestParametersProvider#provideNonPositiveSizeOrNonPositiveSizeRadix",
    })
    void test3_2(int size, int radix) {
        RandomBaseballNumberGenerator rng = new RandomBaseballNumberGenerator();
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> rng.generateRandomBaseballNumber(size, radix));
    }

    public void checkBaseballNumber(BaseballNumber baseballNumber) {
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
