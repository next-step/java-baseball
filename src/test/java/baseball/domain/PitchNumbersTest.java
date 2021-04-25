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

    @Test
    void 스트라이크_카운트_테스트() {
        // given
        PitchNumbers pitchNumbers = PitchNumbers.of("123");
        // when & then
        assertThat(pitchNumbers.matchStrike(PitchNumbers.of("135"))).isEqualTo(1);
        assertThat(pitchNumbers.matchStrike(PitchNumbers.of("125"))).isEqualTo(2);
        assertThat(pitchNumbers.matchStrike(PitchNumbers.of("123"))).isEqualTo(3);
    }

    @Test
    void 볼_카운트_테스트() {
        // given
        PitchNumbers pitchNumbers = PitchNumbers.of("123");
        // when & then
        assertThat(pitchNumbers.matchBall(PitchNumbers.of("541"))).isEqualTo(1);
        assertThat(pitchNumbers.matchBall(PitchNumbers.of("315"))).isEqualTo(2);
        assertThat(pitchNumbers.matchBall(PitchNumbers.of("312"))).isEqualTo(3);
    }
}
