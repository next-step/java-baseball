package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PitchNumberTest {
    @Test
    void 생성_테스트() {
        // given
        PitchNumber pitchNumber = PitchNumber.of(8);
        // when & then
        assertThat(pitchNumber).isEqualTo(PitchNumber.of(8));
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumber.of(10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumber.of(-1));
    }
}
