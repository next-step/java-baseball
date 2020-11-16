package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayTest {
    public static final List<Integer> TARGET = Arrays.asList(7, 1, 3);

    Play sut;

    @DisplayName("이겼는지 ")
    @Test
    void hasWin() {
        sut = Play.of(TARGET, TARGET);
        Assertions.assertTrue(sut.hasWin());
    }

    @DisplayName("1 스트라이크 1 볼 ")
    @Test
    void getHint_1s_1b() {
        List<Integer> trial = Arrays.asList(1, 2, 3);
        sut = Play.of(TARGET, trial);
        Assertions.assertEquals("1 스트라이크 1 볼 ", sut.getHint());
    }

    @DisplayName("3 스트라이크")
    @Test
    void getHint_3s() {
        sut = Play.of(TARGET, TARGET);
        Assertions.assertEquals("3 스트라이크 ", sut.getHint());
    }
}