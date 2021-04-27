package com.woowahan.precourse.baseball.rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallRuleTest {

    private String[] gameNumbers;

    @BeforeEach
    void init() {
        this.gameNumbers = new String[] {"5", "4", "3"};
    }

    @Test
    @DisplayName("동일한 자리의 gameNumber와 inputNumber가 같으면 isStrike는 true 다르면 isStrike는 false")
    void isStrikeTest() {

        String firstInputNumber = "7";
        String secondInputNumber = "4";

        assertThat(BaseBallRule.isStrike(this.gameNumbers[0], firstInputNumber)).isFalse();
        assertThat(BaseBallRule.isStrike(this.gameNumbers[1], secondInputNumber)).isTrue();
    }

    @Test
    @DisplayName("inputNumber가 strike가 아니고 gameNumbers에 inputNumber가 포함되어 있으면 ball")
    void isBallTest() {

        String firstInputNumber = "3";
        String secondInputNumber = "8";
        String thirdInputNumber = "4";

        assertThat(BaseBallRule.isBall(this.gameNumbers, firstInputNumber, 0)).isTrue();
        assertThat(BaseBallRule.isBall(this.gameNumbers, secondInputNumber, 1)).isFalse();
        assertThat(BaseBallRule.isBall(this.gameNumbers, thirdInputNumber, 2)).isTrue();
    }

    @Test
    @DisplayName("strike가 3이면 게임 승리이므로 승리인경우 true 승리가 아닌경우 false 반환")
    void isVictoryTest() {

        // given
        int game1StrikeCount = 3;
        int game2StrikeCount = 2;

        // when
        boolean game1Victory = BaseBallRule.isVictory(game1StrikeCount);
        boolean game2Victory = BaseBallRule.isVictory(game2StrikeCount);

        // then
        assertThat(game1Victory).isTrue();
        assertThat(game2Victory).isFalse();
    }

    @Test
    @DisplayName("strikeCount 가 0이고 ballCount가 0 일때만 포볼, 낫싱")
    void isNothingAndFourBallTest() {

        // given
        int game1StrikeCount = 3;
        int game1BallCount = 0;
        int game2StrikeCount = 0;
        int game2BallCount = 0;
        int game3StrikeCount = 1;
        int game3BallCount = 2;
        int game4StrikeCount = 0;
        int game4BallCount = 3;

        // when
        boolean game1NothingAndFourBall = BaseBallRule.isNothingAndFourBall(game1StrikeCount, game1BallCount);
        boolean game2NothingAndFourBall = BaseBallRule.isNothingAndFourBall(game2StrikeCount, game2BallCount);
        boolean game3NothingAndFourBall = BaseBallRule.isNothingAndFourBall(game3StrikeCount, game3BallCount);
        boolean game4NothingAndFourBall = BaseBallRule.isNothingAndFourBall(game4StrikeCount, game4BallCount);

        // then
        assertThat(game1NothingAndFourBall).isFalse();
        assertThat(game2NothingAndFourBall).isTrue();
        assertThat(game3NothingAndFourBall).isFalse();
        assertThat(game4NothingAndFourBall).isFalse();
    }
}
