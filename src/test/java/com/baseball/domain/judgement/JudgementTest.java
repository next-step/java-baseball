package com.baseball.domain.judgement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given / when
        Judgement judgement = new Judgement(1, 2);

        // then
        assertThat(judgement.getStrike()).isNotNull();
    }

    @DisplayName("스트라이크, 볼 테스트")
    @Test
    void ballCount() {
        // given / when
        Judgement judgement = new Judgement(1, 2);

        // then
        assertThat(judgement.getStrike()).isEqualTo(1);
        assertThat(judgement.getBall()).isEqualTo(2);
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothing() {
        // given / when
        Judgement judgement1 = new Judgement(0, 0);
        Judgement judgement2 = new Judgement(1, 0);
        Judgement judgement3 = new Judgement(0, 1);

        // then
        assertThat(judgement1.isNothing()).isTrue();
        assertThat(judgement2.isNothing()).isFalse();
        assertThat(judgement3.isNothing()).isFalse();
    }

}