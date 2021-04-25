package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    /**
     * 요구사항 1
     */
    @Test
    void setSizeTest() {
        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    /**
     * 요구사항 2
     * @param number
     */
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void containsElementsOfSetTest1(int number) {
        // then
        assertThat(numbers.contains(number)).isTrue();
    }


    /**
     * 요구사항 3
     * @param containedNumber
     * @param notContainedNumber
     */
    @ParameterizedTest
    @CsvSource(value = { "1:4", "2:5", "3:6" }, delimiter = ':')
    void containsElementsOfSetTest2(int containedNumber, int notContainedNumber) {
        // then
        assertThat(numbers.contains(containedNumber)).isTrue();
        assertThat(numbers.contains(notContainedNumber)).isFalse();
    }
}
