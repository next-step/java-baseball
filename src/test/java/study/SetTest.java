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

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/21
 * Time : 11:17 PM
 */

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1 size")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항2 contains")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
    }

    @DisplayName("요구사항2 contains 중복제거")
    @ParameterizedTest()
    @ValueSource(ints = {1,2,3})
    void containsNotDuplication(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3 contains true & false 모두 체크")
    @ParameterizedTest()
    @CsvSource( value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsOrNotContains(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }


}
