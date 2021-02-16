package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @DisplayName("1볼 1스트라이크")
    @Test
    void makeDecisionAnd1Ball1Strike() {
        // given
        Numbers numbers1 = new Numbers(List.of(7, 1, 3));
        Numbers numbers2 = new Numbers(List.of(1, 2, 3));
        Judge judge = new Judge();

        // when
        BallCount ballCount = judge.makeDecision(numbers1, numbers2);

        // then
        BallCount expected = new BallCount(1, 1);
        assertThat(ballCount).isEqualTo(expected);
    }

    @DisplayName("3스트라이크")
    @Test
    void makeDecisionAnd3Strikes() {
        // given
        Numbers numbers1 = new Numbers(List.of(7, 1, 3));
        Numbers numbers2 = new Numbers(List.of(7, 1, 3));
        Judge judge = new Judge();

        // when
        BallCount ballCount = judge.makeDecision(numbers1, numbers2);

        // then
        BallCount expected = new BallCount(0, 3);
        assertThat(ballCount).isEqualTo(expected);
    }

    @DisplayName("0볼 0스트라이크")
    @Test
    void makeDecisionAnd0Ball0Strike() {
        // given
        Numbers numbers1 = new Numbers(List.of(7, 1, 3));
        Numbers numbers2 = new Numbers(List.of(2, 6, 5));
        Judge judge = new Judge();

        // when
        BallCount ballCount = judge.makeDecision(numbers1, numbers2);

        // then
        BallCount expected = new BallCount(0, 0);
        assertThat(ballCount).isEqualTo(expected);
    }
}
