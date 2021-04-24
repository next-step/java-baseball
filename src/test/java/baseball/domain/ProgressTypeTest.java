package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProgressTypeTest {

    @Test
    void 찾기_테스트() {
        assertThat(ProgressType.of(1)).isEqualTo(ProgressType.PLAY);
        assertThat(ProgressType.of(2)).isEqualTo(ProgressType.STOP);
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ProgressType.of(3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ProgressType.of(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ProgressType.of(5));
    }
}
