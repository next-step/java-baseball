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

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 1, 2, 3",
            "4, 5, 6, 4, 5, 6",
            "7, 8, 9, 7, 8, 9",
            "1, 5, 9, 1, 5, 9",
            "4, 9, 1, 4, 9, 1"
    })
    void 스트라이크3_테스트(int a1, int a2, int a3, int b1, int b2, int b3) {
        //given
        final int EXPECTED_STRIKE_COUNT = 3;
        final int EXPECTED_BALL_COUNT = 0;
        final int EXPECTED_NOTHING_COUNT = 0;
        BaseballNumbers baseballNumbers = BaseballNumbers.create(List.of(a1, a2, a3));
        BaseballNumbers targetBaseballNumbers = BaseballNumbers.create(List.of(b1, b2, b3));

        //when
        BaseballResults baseballResults = baseballNumbers.compareTo(targetBaseballNumbers);

        //then
        assertEquals(EXPECTED_STRIKE_COUNT, baseballResults.getCount(Pitching.STRIKE));
        assertEquals(EXPECTED_BALL_COUNT, baseballResults.getCount(Pitching.BALL));
        assertEquals(EXPECTED_NOTHING_COUNT, baseballResults.getCount(Pitching.NOTHING));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 3, 1, 2",
            "4, 5, 6, 6, 4, 5",
            "7, 8, 9, 9, 7, 8",
            "1, 5, 9, 5, 9, 1",
            "4, 9, 1, 1, 4, 9"
    })
    void 볼3_테스트(int a1, int a2, int a3, int b1, int b2, int b3) {
        //given
        final int EXPECTED_STRIKE_COUNT = 0;
        final int EXPECTED_BALL_COUNT = 3;
        final int EXPECTED_NOTHING_COUNT = 0;
        BaseballNumbers baseballNumbers = BaseballNumbers.create(List.of(a1, a2, a3));
        BaseballNumbers targetBaseballNumbers = BaseballNumbers.create(List.of(b1, b2, b3));

        //when
        BaseballResults baseballResults = baseballNumbers.compareTo(targetBaseballNumbers);

        //then
        assertEquals(EXPECTED_STRIKE_COUNT, baseballResults.getCount(Pitching.STRIKE));
        assertEquals(EXPECTED_BALL_COUNT, baseballResults.getCount(Pitching.BALL));
        assertEquals(EXPECTED_NOTHING_COUNT, baseballResults.getCount(Pitching.NOTHING));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 1, 3, 2",
            "4, 5, 6, 6, 5, 4",
            "7, 8, 9, 7, 9, 8",
            "1, 5, 9, 9, 5, 1",
            "4, 9, 1, 9, 4, 1"
    })
    void 스트라이크1_볼2_테스트(int a1, int a2, int a3, int b1, int b2, int b3) {
        //given
        final int EXPECTED_STRIKE_COUNT = 1;
        final int EXPECTED_BALL_COUNT = 2;
        final int EXPECTED_NOTHING_COUNT = 0;
        BaseballNumbers baseballNumbers = BaseballNumbers.create(List.of(a1, a2, a3));
        BaseballNumbers targetBaseballNumbers = BaseballNumbers.create(List.of(b1, b2, b3));

        //when
        BaseballResults baseballResults = baseballNumbers.compareTo(targetBaseballNumbers);

        //then
        assertEquals(EXPECTED_STRIKE_COUNT, baseballResults.getCount(Pitching.STRIKE));
        assertEquals(EXPECTED_BALL_COUNT, baseballResults.getCount(Pitching.BALL));
        assertEquals(EXPECTED_NOTHING_COUNT, baseballResults.getCount(Pitching.NOTHING));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6",
            "4, 5, 6, 7, 8, 9",
            "7, 8, 9, 1, 3, 5",
            "1, 5, 9, 2, 4, 8",
            "4, 9, 1, 8, 5, 3"
    })
    void 낫싱3_테스트(int a1, int a2, int a3, int b1, int b2, int b3) {
        //given
        final int EXPECTED_STRIKE_COUNT = 0;
        final int EXPECTED_BALL_COUNT = 0;
        final int EXPECTED_NOTHING_COUNT = 3;
        BaseballNumbers baseballNumbers = BaseballNumbers.create(List.of(a1, a2, a3));
        BaseballNumbers targetBaseballNumbers = BaseballNumbers.create(List.of(b1, b2, b3));

        //when
        BaseballResults baseballResults = baseballNumbers.compareTo(targetBaseballNumbers);

        //then
        assertEquals(EXPECTED_STRIKE_COUNT, baseballResults.getCount(Pitching.STRIKE));
        assertEquals(EXPECTED_BALL_COUNT, baseballResults.getCount(Pitching.BALL));
        assertEquals(EXPECTED_NOTHING_COUNT, baseballResults.getCount(Pitching.NOTHING));
    }
}