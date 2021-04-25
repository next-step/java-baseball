import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NumbersTest {
    @Test
    @DisplayName("기본테스트")
    void init() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assertions.assertThat(numbers.size()).isEqualTo(9);
    }
}
