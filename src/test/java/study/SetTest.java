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

    @DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 테스트")
    @Test
    void test_set_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 의 contains() 메소드를 활용해 1, 2, 3 의 값이 존재하는지를 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test_set_contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("Set 의 contains() 메소드를 활용해 입력값이 set 에 포함될 경우 true 아닐 경우 false 를 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test_set_contains_ture_false(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
