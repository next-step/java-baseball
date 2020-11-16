package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.PitchResult.BALL;
import static baseball.PitchResult.NOTHING;
import static baseball.PitchResult.STRIKE;
import static baseball.Pitches.FIRST_TRY;
import static baseball.Pitches.SECOND_TRY;
import static baseball.Pitches.THIRD_TRY;

class PitchTest {

    public static final List<Integer> TRIAL = Arrays.asList(1, 2, 3);
    public static final List<Integer> TARGET = Arrays.asList(7, 1, 3);
    Pitch sut;

    @DisplayName("BALL 테스트")
    @Test
    void pitchTest_ball_case() {
        sut = Pitch.of(FIRST_TRY, Arrays.asList(1, 2, 3), Arrays.asList(7, 1, 3));
        Assertions.assertEquals(BALL, sut.result);
    }

    @DisplayName("NOTHING 테스트")
    @Test
    void pitchTest_nothing_case() {
        sut = Pitch.of(SECOND_TRY, TRIAL, TARGET);
        Assertions.assertEquals(NOTHING, sut.result);
    }

    @DisplayName("STRIKE 테스트")
    @Test
    void pitchTest_strike_case() {
        sut = Pitch.of(THIRD_TRY, Arrays.asList(1, 2, 3), Arrays.asList(7, 1, 3));
        Assertions.assertEquals(STRIKE, sut.result);
    }
}