package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SetPracticeTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set 크기를 리턴한다.")
    @Test
    void getSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set 입력값 포함여부를 리턴한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsValidNumber(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("목록으로 입력받은 값의 포함여부를 리턴한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,true", "4,5,,false"})
    void containsNumber(Integer input1, Integer input2, Integer input3, boolean isContains) {

        assertAll(
                () -> assertThat(numbers.contains(input1)).isEqualTo(isContains),
                () -> assertThat(numbers.contains(input2)).isEqualTo(isContains),
                () -> assertThat(numbers.contains(input3)).isEqualTo(isContains)
        );
    }
}
