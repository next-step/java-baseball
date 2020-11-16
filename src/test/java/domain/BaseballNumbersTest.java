package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    @DisplayName("중복된 숫자가 있을 경우, Exception 발생.")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void validateDuplicate(Map<Integer, Integer> numbers) {
        assertThatThrownBy(() -> new BaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 숫자 3개만 입력해주세요.");
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
