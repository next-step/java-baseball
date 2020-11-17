package common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("numbers의 크기가 3인지 확인")
    public void size() {
        assertThat(this.numbers.size()).isEqualTo(3);
    }

    @DisplayName("1,2,3 값이 numbers에 있는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void contains(String input) {
        assertThat(this.numbers.contains(Integer.parseInt(input))).isTrue();
    }

    @DisplayName("1부터 5의 값이 numbers에 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void containsTrueAndFalse(String input, String expected) {
        assertEquals(Boolean.parseBoolean(expected)
                    , this.numbers.contains(Integer.parseInt(input)));
    }

}
