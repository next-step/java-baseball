package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBallGameTest {
    private BaseBallGame ballGame;

    @BeforeEach
    void setUp() {
        ballGame = new BaseBallGame(new TestBallMaker());
    }

    @DisplayName("게임 진행")
    @Test
    void play() {
        //given
        Balls balls = new Balls("192");
        Map<Status, Integer> expected = new HashMap<>();
        expected.put(Status.STRIKE, 3);

        //when
        Map<Status, Integer> actual = ballGame.play(balls);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("게임 종료 확인")
    @ParameterizedTest
    @CsvSource(value = {"192,true", "129,false"})
    void is_done(String numbers, boolean expected) {
        //given
        Balls balls = new Balls(numbers);

        //when, then
        assertEquals(expected, ballGame.isDone(balls));
    }
}
