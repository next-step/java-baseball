package study;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.HashSet;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size()를 통해 Set의 크기 확인")
    @Test
    void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains()를 통해 1,2,3의 값이 존재하는지 확인")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용해 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsNumber(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("1, 2, 3을 제외한 나머지 값들도 false처리")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void isContainsNumber(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
