package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    public void testCheckSize() {
      int size = numbers.size();
      assertThat(size)
              .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 consintas() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
    public void testContains(int value) {
        assertThat(this.numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("요구사항3: 기대값과 기대결과를 동적으로 전달하여 확인")
    public void testContainsByCsvSource(int expectedValue, boolean expectedResult) {
        assertThat(this.numbers.contains(expectedValue))
                .isEqualTo(expectedResult);
    }
}
