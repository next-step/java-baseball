package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항1. Set Size 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,true", "4,false"})
    void size(int expected, boolean result) {
        //when, then
        assertEquals(expected == numbers.size(), result);
    }

    @DisplayName("요구사항2. contains() 활용하여 값 존재 여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        //when, then
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("요구사항2. contains() 활용하여 값 존재 여부 확인 - 미포함 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
    void contains_or_not(int value, boolean expected) {
        //when
        boolean actual = numbers.contains(value);

        //then
        assertEquals(expected, actual);
    }
}
