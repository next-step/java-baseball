import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RandomStringTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("입력된 파라미터 길이를 반환한다")
    void test1(int length) {
        assertThat(RandomString.generate(length).length()).isEqualTo(length);
    }

    @Test
    @DisplayName("생성된 모든 숫자는 다르다")
    void test2() {
        String generated = RandomString.generate(3);
        assertThat(generated.charAt(0) != generated.charAt(1)).isTrue();
        assertThat(generated.charAt(1) != generated.charAt(2)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("숫자는 1에서 9까지만 생성된다")
    void test3(int index) {
        String generated = RandomString.generate(3);
        int target = Integer.parseInt(generated.substring(index, index + 1));
        assertThat(target >= 1 && target <= 9).isTrue();
    }
}
