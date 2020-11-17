package me.kingcjy.baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author KingCjy
 */
class BallNumberTest {

    @Test
    @DisplayName("1 ~ 9이외의 다른 값이 들어갈 때 throw Exception")
    public void createTest() {
        assertThatThrownBy(() -> {
            new BallNumber(10, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

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