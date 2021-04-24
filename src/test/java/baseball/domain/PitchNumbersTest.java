package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PitchNumbersTest {

    @Test
    void 생성_테스트() {
        // given
        PitchNumbers pitchNumbers = PitchNumbers.of("123");
        PitchNumbers pitchNumbers2 = PitchNumbers.of(Arrays.asList(PitchNumber.of(1), PitchNumber.of(2), PitchNumber.of(3)));
        // when & then
        assertThat(pitchNumbers).isEqualTo(pitchNumbers2);
    }

    @Test
    void 자리수_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumbers.of("1234"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumbers.of("12"));
    }

    @Test
    void 중복_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumbers.of("122"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchNumbers.of("121"));
    }
}
