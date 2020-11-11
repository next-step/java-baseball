package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("임의의 수 생성 시 1 ~ 9 사이의 3자리의 수를 생성")
    void testNormal() {
        Number ball = new Number();
        List<Integer> numbers = ball.getNumbers();
        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("임의의 수 생성 시 서로 다른 수로 이뤄진 수를 생성")
    void testHasDifferentNumbers() {
        Number ball = new Number();
        Set<Integer> numbers = new HashSet<>(ball.getNumbers());
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("직접 생성 시 0이 존재하면 예외 발생")
    void testHasZeroThrowException() {
        assertThatThrownBy(() -> new Number("109")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 같은 수가 존재하면 예외 발생")
    void testHasSameNumbersThrowException() {
        assertThatThrownBy(() -> new Number("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 3자리가 아닐 경우 예외 발생")
    void testOverLengthThrowException() {
        assertThatThrownBy(() -> new Number("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Number("15")).isInstanceOf(IllegalArgumentException.class);
    }
}
