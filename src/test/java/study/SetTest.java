package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("size 확인 테스트")
    @Test
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("값 포함 여부 확인 테스트")
    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    public void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

}
