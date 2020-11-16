package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PitchesTest {

    public static final List<Integer> TARGET = Arrays.asList(7, 1, 3);
    Pitches sut;

    @DisplayName("1스트라이크 1볼")
    @Test
    void pitchesTest_1s_1b() {
        List<Integer> trials = Arrays.asList(1, 2, 3);
        sut = Pitches.of(trials, TARGET);
        Assertions.assertEquals(1, sut.strikeCount());
        Assertions.assertEquals(1, sut.ballCount());
    }

    @DisplayName("낫싱")
    @Test
    void pitchesTest_nothing() {
        List<Integer> trials = Arrays.asList(4, 5, 6);
        sut = Pitches.of(trials, TARGET);
        Assertions.assertEquals(0, sut.strikeCount());
        Assertions.assertEquals(0, sut.ballCount());
    }
}