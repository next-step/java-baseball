package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    private BaseballNumbers baseballNumbers;

    @BeforeEach
    void setUp() {
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(3, 0);
        numbers.put(7, 1);
        numbers.put(2, 2);

        baseballNumbers = new BaseballNumbers(numbers);
    }

    @DisplayName("중복된 숫자가 있을 경우, Exception 발생.")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void validateDuplicate(Map<Integer, Integer> numbers) {
        assertThatThrownBy(() -> new BaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 숫자로 3개 입력해주세요.");
    }

    @DisplayName("입력받은 숫자와 3자리 수 비교해서 그 중 하나가 위치와 값이 일치할 경우, STRIKE 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "7:1", "2:2"}, delimiter = ':')
    void compareNumbers_STRIKE(int number, int order) {
        Score resultScore = baseballNumbers.compareNumbers(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.STRIKE);
    }

    @DisplayName("입력받은 숫자와 3자리 수 비교해서 그 중 하나가 위치는 다르지만 값이 일치할 경우, BALL 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "7:2"}, delimiter = ':')
    void compareNumbers_BALL(int number, int order) {
        Score resultScore = baseballNumbers.compareNumbers(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.BALL);
    }

    @DisplayName("입력받은 숫자와 3자리 수 비교해서 그 중 일치하는 값이 하나도 없을 경, NOTHING 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"5:0", "6:1"}, delimiter = ':')
    void compareNumbers_NOTHING(int number, int order) {
        Score resultScore = baseballNumbers.compareNumbers(new BaseballNumber(new Order(order), number));
        assertThat(resultScore).isEqualTo(Score.NOTHING);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(convertToMap(Arrays.asList(1, 2, 1))),
                Arguments.of(convertToMap(Arrays.asList(4, 7, 4))),
                Arguments.of(convertToMap(Arrays.asList(9, 9, 9)))
        );
    }

    private static Map<Integer, Integer> convertToMap(List<Integer> numbers) {
        Map<Integer, Integer> convertNumbers = new LinkedHashMap<>();
        for (int index = 0; index < numbers.size(); index++) {
            convertNumbers.put(numbers.get(index), index);
        }
        return convertNumbers;
    }
}
