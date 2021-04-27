package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
    void 요구사항1() {

        Assertions.assertThat(numbers)
                .isNotNull()
                .hasSize(3);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 요구사항2(int number) {

        Assertions.assertThat(numbers)
                .isNotNull()
                .contains(number);

    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void 요구사항3(String input, String expected) {
        int number = Integer.parseInt(input);
        boolean expectedBoolean = Boolean.parseBoolean(expected);
        Assertions.assertThat(numbers.contains(number))
                .isNotNull()
                .isEqualTo(expectedBoolean);

    }
}
