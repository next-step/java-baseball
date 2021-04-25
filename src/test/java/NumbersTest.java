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
    void strike() {
        assertThat(numbers.strike(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @BeforeEach
    void init() {
        numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
