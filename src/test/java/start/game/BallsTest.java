package start.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private Balls com;

    @BeforeEach
    public void setup() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    public void play_thing() {
        PlayResult result = com.play(Arrays.asList(7, 8, 9));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void play_one_one() {
        PlayResult result = com.play(Arrays.asList(1, 3, 4));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void play_three() {
        PlayResult result = com.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isEqualTo(true);
    }

    @Test
    public void play_two_no() {
        PlayResult result = com.play(Arrays.asList(1, 2, 5));
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void notThingall() {
        PlayResult result = com.play(Arrays.asList(7, 8, 9));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void strike() {
        assertThat(com.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ball() {
        assertThat(com.play(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void nothing() {
        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
    }
}
