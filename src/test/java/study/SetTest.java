package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection 에 대한 학습 테스트")
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

    @DisplayName("요구사항 1 - size")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항 2 - contains")
    @ParameterizedTest
    @ValueSource(ints={1, 2, 3})
    void contains(int data) {
        assertThat(numbers.contains(data)).isTrue();
    }

    @DisplayName("요구사항 3 - contains")
    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int data, boolean result) {
        assertThat(numbers.contains(data)).isEqualTo(result);
    }

}
