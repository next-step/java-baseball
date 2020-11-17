package com.sang5c.baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballCountTest {

    BaseballCount baseballCount;

    @BeforeEach
    public void setup() {
        baseballCount = new BaseballCount();
    }

    @DisplayName("default 생성자 0, 0으로 생성")
    @Test
    public void test() {
        assertThat(baseballCount.isNothing()).isTrue();
    }

    @DisplayName("ball count 1 증가")
    @Test
    public void increaseBallCount() {
        baseballCount = baseballCount.increaseBallCount();
        assertThat(baseballCount.getBallCount()).isEqualTo(1);
    }

    @DisplayName("strike count 1 증가")
    @Test
    public void increaseStrikeCount() {
        baseballCount = baseballCount.increaseStrikeCount();
        assertThat(baseballCount.getStrikeCount()).isEqualTo(1);
    }

}
