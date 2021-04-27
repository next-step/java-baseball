package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    @DisplayName("스트라이크 개수를 갖는다.")
    public void 스트라이크_개수를_갖는다() {
        List<Pitching> pitchingList = Arrays.asList(Pitching.STRIKE, Pitching.STRIKE);
        Score score = new Score(pitchingList);

        assertThat(score.countOfStrike())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수를 갖는다.")
    public void 볼_개수를_갖는다() {
        List<Pitching> pitchingList = Arrays.asList(Pitching.BALL, Pitching.BALL, Pitching.BALL);
        Score score = new Score(pitchingList);

        assertThat(score.countOfBall())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("미싱 개수를 갖는다.")
    public void 미싱_개수를_갖는다() {
        List<Pitching> pitchingList = Arrays.asList(Pitching.MISSING);
        Score score = new Score(pitchingList);

        assertThat(score.countOfMissing())
                .isEqualTo(1);
    }
}
