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

    @DisplayName("set 사이즈 테스트")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("set에 요소가 포함되어 있는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains1(int expected) {
        assertThat(numbers.contains(expected)).isTrue();
    }

    @DisplayName("set에 요소가 포함 혹은 미포함 되었는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int expected, boolean result) {
        assertThat(numbers.contains(expected)).isEqualTo(result);
    }
}
