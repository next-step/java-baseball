package set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Set Size Test")
    void setTest1() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("check contains true")
    @ValueSource(ints = {1, 2, 3})
    void setTest2(int i) {
        Assertions.assertThat(numbers.contains(i)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("check contains true or not")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setTest3(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }


}
