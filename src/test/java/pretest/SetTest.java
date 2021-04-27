package pretest;

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
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈 확인 테스트")
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set의 contains()메소드를 활용한 1,2,3 값 존재 확인 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과값이 다른 경우에 대한 테스트")
    void containsTrueFalseTest() {
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);
        assertThat(numbers.contains(4)).isEqualTo(false);
        assertThat(numbers.contains(5)).isEqualTo(false);
    }
}
