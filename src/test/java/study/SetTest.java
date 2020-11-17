package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("Set의 사이즈")
    @Test
    void requirements_01() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 입력값 존재여부")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void requirements_02(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("Set에 입력값 존재여부")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void requirements_03(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
