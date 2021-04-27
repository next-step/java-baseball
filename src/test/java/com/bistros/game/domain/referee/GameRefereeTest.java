package com.bistros.game.domain.referee;

import com.bistros.game.domain.ball.BallNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameRefereeTest {


    @Test
    @DisplayName("낫싱 테스트")
    void test_0_0() {
        GameReferee referee = new GameReferee(new BallNumbers(Arrays.asList(2, 3, 1)));
        InningReport report = referee.check(Arrays.asList(4, 5, 6));

        System.out.println(report);
        assertAll(
            () -> assertThat(report.getStrike()).isEqualTo(0),
            () -> assertThat(report.getBall()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("1 스트라이크 1 볼")
    void test_1_1() {
        GameReferee referee = new GameReferee(new BallNumbers(Arrays.asList(2, 3, 1)));
        InningReport report = referee.check(Arrays.asList(3, 9, 1));

        assertAll(
            () -> assertThat(report.getStrike()).isEqualTo(1),
            () -> assertThat(report.getBall()).isEqualTo(1)

        );
    }

    @Test
    @DisplayName("2볼")
    void test_0_2() {
        GameReferee referee = new GameReferee(new BallNumbers(Arrays.asList(2, 3, 1)));
        InningReport report = referee.check(Arrays.asList(1, 2, 9));

        assertAll(
            () -> assertThat(report.getStrike()).isEqualTo(0),
            () -> assertThat(report.getBall()).isEqualTo(2)

        );
    }

    @Test
    @DisplayName("3 스트라이크")
    void test_3_0() {
        GameReferee referee = new GameReferee(new BallNumbers(Arrays.asList(2, 3, 1)));
        InningReport report = referee.check(Arrays.asList(2, 3, 1));

        assertAll(
            () -> assertThat(report.getStrike()).isEqualTo(3),
            () -> assertThat(report.getBall()).isEqualTo(0)

        );
    }
}