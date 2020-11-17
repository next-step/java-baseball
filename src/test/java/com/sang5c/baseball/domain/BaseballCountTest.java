package com.sang5c.baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballCountTest {

    BaseballCount count;

    @BeforeEach
    public void setup() {
        count = BaseballCount.of(0, 0);
    }
    @DisplayName("카운트의 합은 0이상 3이하이다")
    @Test
    public void countSum() {
        assertThatCode(() -> BaseballCount.of(0, 3)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> BaseballCount.of(1, 3));
    }

    @DisplayName("카운트가 모두 0이면 낫싱")
    @Test
    public void nothing() {
        assertThat(count.isNothing()).isTrue();
    }

    @DisplayName("ball count 증가")
    @Test
    public void increaseBallCount() {
        BaseballCount baseballCount = count.increaseBallCount();
        assertThat(baseballCount.getBallCount()).isEqualTo(1);
    }

    @DisplayName("strike count 증가")
    @Test
    public void increaseStrikeCount() {
        BaseballCount baseballCount = count.increaseStrikeCount();
        assertThat(baseballCount.getStrikeCount()).isEqualTo(1);
    }

}
