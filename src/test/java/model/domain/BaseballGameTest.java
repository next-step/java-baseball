package model.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    static BaseballGame game;

    @BeforeAll
    static void setUp() {
        List<Ball> balls = new ArrayList<>();
        balls.add(Ball.of(1));
        balls.add(Ball.of(2));
        balls.add(Ball.of(3));

        game = new BaseballGame(balls);
    }

    @Test
    void play_win() {
        Record record = game.play(Balls.of("123"));
        assertThat(record.isWin()).isTrue();
    }

    @Test
    void play_strike_ball() {
        Record record = game.play(Balls.of("132"));

        assertThat(record.getStrikeCount()).isEqualTo(1);
        assertThat(record.getBallCount()).isEqualTo(2);
    }

    @Test
    void play_not_thing() {
        Record record = game.play(Balls.of("456"));
        assertThat(record.isNotThing()).isTrue();
    }
}
