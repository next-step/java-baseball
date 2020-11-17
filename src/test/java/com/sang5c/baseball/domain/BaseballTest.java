package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballTest {

    @DisplayName("number 중복시 에러")
    @Test
    public void duplicate() {
        assertThatIllegalArgumentException().isThrownBy(() -> Baseball.of("122"));
    }

    @DisplayName("number 길이가 3이 아니면 에러")
    @Test
    public void invalidSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> Baseball.of("12"));
    }

    @DisplayName("3스트라이크 카운트 비교")
    @Test
    public void compareThreeStrike() {
        Baseball baseball = Baseball.of("123");
        BaseballCount ballCount = baseball.compare(Baseball.of("123"));
        assertThat(ballCount.getBallCount()).isEqualTo(0);
        assertThat(ballCount.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("1볼 1스트라이크 카운트 비교")
    @Test
    public void compareOneBallOneStrike() {
        Baseball baseball = Baseball.of("123");
        BaseballCount ballCount = baseball.compare(Baseball.of("324"));
        assertThat(ballCount.getBallCount()).isEqualTo(1);
        assertThat(ballCount.getStrikeCount()).isEqualTo(1);
    }

    @DisplayName("낫싱 카운트 비교")
    @Test
    public void compareIsNothing() {
        Baseball baseball = Baseball.of("123");
        BaseballCount ballCount = baseball.compare(Baseball.of("456"));
        assertThat(ballCount.getBallCount()).isEqualTo(0);
        assertThat(ballCount.getStrikeCount()).isEqualTo(0);
    }
}
