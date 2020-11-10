package learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 내장 메서드로 크기를 확인할 수 있다.")
    @Test
    void sizeTest() {
        int expectedSize = 3;

        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @DisplayName("Set의 내장 메서드로 특정 요소의 포함 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int expectedResult) {
        assertThat(numbers).contains(expectedResult);
    }
}
