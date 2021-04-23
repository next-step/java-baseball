package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import baseball.util.random.RandomBaseballNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BaseballNumberTest {
    private static final int MAX_RADIX = BaseballNumber.MAX_RADIX;

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {"provideSizeAndRadix", "provideNonPositiveSizeOrNonPositiveSizeRadix", "provideTooMuchSizeOrTooMuchRadix"})
    public void test1_1_baseballNumber_builder_generate_number_which_does_not_contain_0(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).build();
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

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").addAll().build()")
    @MethodSource(value = {"provideSizeAndRadix", "provideNonPositiveSizeOrNonPositiveSizeRadix", "provideTooMuchSizeOrTooMuchRadix"})
    public void test1_2_baseballNumber_builder_generate_number_which_does_not_contain_0(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).addAll().build();
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

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").addRandomNumber(size).build()")
    @MethodSource(value = {"provideSizeAndRadix", "provideNonPositiveSizeOrNonPositiveSizeRadix", "provideTooMuchSizeOrTooMuchRadix"})
    public void test1_3_baseballNumber_builder_generate_number_which_does_not_contain_0(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).addRandomNumber(size).build();
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

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {"provideSizeAndRadix", "provideNonPositiveSizeOrNonPositiveSizeRadix", "provideTooMuchSizeOrTooMuchRadix"})
    public void test2_baseballNumber_builder_can_generate_random_number_any_size_and_any_radix(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).build();
        int[] numbers = baseballNumber.getNumbers();

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        assertThat(set).hasSize(numbers.length);
        assertThat(baseballNumber).asString().hasSize(numbers.length);
        assertThat(baseballNumber.getSize()).isEqualTo(numbers.length);
    }

    @ParameterizedTest(name = "BaseballNumber.builder().("+ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER+").build()")
    @MethodSource(value = {"provideSizeAndRadix", "provideTooMuchSizeOrTooMuchRadix"})
    public void test3_baseballNumber_constructor_and_random_baseball_number_generator(int size, int radix) {
        BaseballNumber baseballNumber =new RandomBaseballNumberGenerator().generateRandomBaseballNumber(size, radix);
        int[] numbers = baseballNumber.getNumbers();

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        assertThat(set).hasSize(numbers.length);
        assertThat(baseballNumber).asString().hasSize(numbers.length);
        assertThat(baseballNumber.getSize()).isEqualTo(numbers.length);
    }

    @ParameterizedTest
    @CsvSource(value = {"112", "1234", "1123"}, delimiter = ':')
    public void test6_baseballNumber_builder_can_generate_random_number_any_size_and_any_radix(String input) {
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> new BaseballNumber(input));
    }



    private static List<Arguments> provideSizeAndRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = 2; radix <= MAX_RADIX; radix++) {
            for (int size = 1; size < radix; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideNonPositiveSizeOrNonPositiveSizeRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = -MAX_RADIX; radix <= 1; radix++) {
            for (int size = -MAX_RADIX; size <= 0; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideTooMuchSizeOrTooMuchRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MAX_RADIX * 2; radix > MAX_RADIX; radix--) {
            for (int size = 2 * radix; size >= radix; size--) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }
}
