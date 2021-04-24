package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PitchResultTest {

    @Test
    void 생성_테스트() {
        assertThat(PitchResult.of(2, 1)).isEqualTo(PitchResult.of(2, 1));
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchResult.of(3, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PitchResult.of(1, 3));
    }

    @Test
    void 종료_테스트() {
        // given
        PitchResult pitchResult = PitchResult.of(3, 0);
        PitchResult pitchResult2 = PitchResult.of(1, 2);

        // when & then
        assertThat(pitchResult.isFinished()).isTrue();
        assertThat(pitchResult2.isFinished()).isFalse();
    }

    @Test
    void 스트라이크_존재_여부_테스트() {
        // given
        PitchResult pitchResult = PitchResult.of(1, 2);
        PitchResult pitchResult2 = PitchResult.of(0, 3);

        // when & then
        assertThat(pitchResult.isExistsStrike()).isTrue();
        assertThat(pitchResult2.isExistsStrike()).isFalse();
    }

    @Test
    void 볼_존재_여부_테스트() {
        // given
        PitchResult pitchResult = PitchResult.of(1, 2);
        PitchResult pitchResult2 = PitchResult.of(3, 0);

        // when & then
        assertThat(pitchResult.isExistsBall()).isTrue();
        assertThat(pitchResult2.isExistsBall()).isFalse();
    }

    @Test
    void 낫싱_테스트() {
        // given
        PitchResult pitchResult = PitchResult.of(0, 0);
        PitchResult pitchResult2 = PitchResult.of(0, 3);

        // when
        boolean result = !pitchResult.isExistsBall() && !pitchResult.isExistsStrike();
        boolean result2 = !pitchResult2.isExistsBall() && !pitchResult2.isExistsStrike();

        // then
        assertThat(result).isTrue();
        assertThat(result2).isFalse();
    }
}
