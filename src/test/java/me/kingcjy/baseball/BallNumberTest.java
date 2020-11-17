package me.kingcjy.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
class BallNumberTest {

    @Test
    @DisplayName("같은 숫자, 같은 포지션일 때 Score.STRIKE를 리턴한다.")
    public void getScoreTest() {
        BallNumber ballNumber = new BallNumber(1, 1);
        BallNumber other = new BallNumber(1, 1);

        assertThat(ballNumber.getScore(other)).isEqualTo(Score.STRIKE);
    }

    @Test
    @DisplayName("같은 숫자, 다른 포지션일 때 Score.BALL을 리턴한다.")
    public void getScoreTest2() {
        BallNumber ballNumber = new BallNumber(1, 1);
        BallNumber other = new BallNumber(1, 2);

        assertThat(ballNumber.getScore(other)).isEqualTo(Score.BALL);
    }

    @Test
    @DisplayName("다른 숫자일 때 Score.NOTHING을 리턴한다.")
    public void getScoreTest3() {
        BallNumber ballNumber = new BallNumber(1, 1);
        BallNumber other = new BallNumber(2, 1);

        assertThat(ballNumber.getScore(other)).isEqualTo(Score.NOTHING);
    }

}