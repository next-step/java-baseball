package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"3,10", "4,8", "5,16", "3,20"}, delimiter = ',')
    public void test1(int size, int radix) {
        BaseballNumber baseballNumber = BaseballNumber.builder().size(size).radix(radix).build();
        int[] numbers = baseballNumber.getNumbers();

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        System.out.println(baseballNumber);
        assertThat(set).hasSize(size);
    }
}
