package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3",
            "4, 5, 6",
            "7, 8, 9",
            "1, 5, 9",
            "4, 9, 1"
    })
    void 중복되지_않는_숫자는_모두_생성된다(int a, int b, int c) {
        final int EXPECTED_SIZE = 3;
        List<Integer> numbers = List.of(a, b, c);
        BaseballNumbers baseballNumbers = BaseballNumbers.create(numbers);
        assertEquals(EXPECTED_SIZE, baseballNumbers.size());
    }

    @Test
    void 중복된_숫자는_생성되지_않는다() {
        //given
        final int EXPECTED_SIZE = 1;
        List<Integer> duplicatedNumbers = List.of(1, 1, 1);
        BaseballNumbers baseballNumbers = BaseballNumbers.create(duplicatedNumbers);

        //then
        assertEquals(EXPECTED_SIZE, baseballNumbers.size());
    }

}