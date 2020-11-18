package com.github.sangholeedev.javabaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UmpireTest {
    @Test
    @DisplayName("스트라이크 판정 테스트")
    void strike_test() {
        int opponent = 123;
        int player = 123;
        List<BallDecision> ballDecisionList = Umpire.validBaseball(opponent, player);

        assertThat(ballDecisionList).contains(BallDecision.STRIKE);
    }

    @Test
    @DisplayName("스트라이크 판정 테스트")
    void ball_test() {
        int opponent = 123;
        int player = 231;
        List<BallDecision> ballDecisionList = Umpire.validBaseball(opponent, player);

        assertThat(ballDecisionList).contains(BallDecision.BALL);
    }
}
