import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {
    Numbers numbers;

    @Test
    @DisplayName("사이즈확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(9);
    }

    @Test
    @DisplayName("스트라이크 확인")
    void strike() {
        assertThat(numbers.strike(Arrays.asList(1, 2, 3))).isEqualTo(3);
        assertThat(numbers.strike(Arrays.asList(1, 2, 4))).isEqualTo(2);
        assertThat(numbers.strike(Arrays.asList(5, 6, 7))).isEqualTo(0);
    }


    @Test
    @DisplayName("볼 확인")
    void ball() {
        assertThat(numbers.ball(Arrays.asList(1, 2, 3))).isEqualTo(0);
        assertThat(numbers.ball(Arrays.asList(1, 2, 4))).isEqualTo(0);
        assertThat(numbers.ball(Arrays.asList(5, 6, 7))).isEqualTo(0);
        assertThat(numbers.ball(Arrays.asList(3, 1, 2))).isEqualTo(3);
        assertThat(numbers.ball(Arrays.asList(3, 2, 1))).isEqualTo(2);
        assertThat(numbers.ball(Arrays.asList(2, 1, 3))).isEqualTo(2);
        assertThat(numbers.ball(Arrays.asList(2, 3, 1))).isEqualTo(3);
    }

    @Test
    @BeforeEach
    void init() {
        numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
