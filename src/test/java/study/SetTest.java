package study;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("Set 크기 확인")
    void checkSetSize() {

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("값 존재 테스트 - 중복코드 작성")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("값 존재 테스트 - 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_removeDupCode(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("값 존재 테스트 - CSV Literals 활용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_useCsvLiterals(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
