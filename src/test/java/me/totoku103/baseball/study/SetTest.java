package me.totoku103.baseball.study;

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
    @DisplayName("요구사항1: Set의 size() 메소드를 활용해 SET의 크기를 확인")
    public void sizeTest() {
        final int size = this.numbers.size();

        assertThat(size)
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2: 중복 코드 없이 존재값을 확인")
    public void containsTest(int value) {
        assertThat(this.numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0, false", "1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("요구사항3: 기대값과 기대결과를 동적으로 전달하여 확인")
    public void containsTest_dynamicResultCode(int expectedValue, boolean expectedResult) {
        assertThat(this.numbers.contains(expectedValue))
                .isEqualTo(expectedResult);
    }
}
