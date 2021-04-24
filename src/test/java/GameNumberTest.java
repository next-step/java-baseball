import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {
    @Test
    @DisplayName("랜덤으로 생성된 3자리 숫자가 0을 포함하지 않는다.")
    void checkZeroExistsTest() {
        assertThat(GameNumber.randomGenerate().contains(0)).isFalse();
    }

    @Test
    @DisplayName("랜덤으로 생성된 3자리 숫자의 크기가 세 자리다.")
    void checkSizeTest() {
        List<Integer> test = GameNumber.randomGenerate();
        assertThat(GameNumber.randomGenerate().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤으로 생성된 3자리 숫자가 중복되지 않는다.")
    void checkDuplicationTest() {
        Set<Integer> gameNumberSet = new HashSet<>(GameNumber.randomGenerate());
        assertThat(gameNumberSet.size()).isEqualTo(3);
    }
}