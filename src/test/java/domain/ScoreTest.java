package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("매치 포인트에 따라 스트라이크(2),볼(1),낫싱(0) 여부 가져오기")
    @Test
    public void scoreMatch() {
        assertThat(Score.findScore(2)).isEqualTo(Score.STRIKE);
        assertThat(Score.findScore(1)).isEqualTo(Score.BALL);
        assertThat(Score.findScore(0)).isEqualTo(Score.NOTHING);
    }
}
