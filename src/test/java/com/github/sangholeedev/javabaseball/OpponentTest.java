package com.github.sangholeedev.javabaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OpponentTest {
    private final Opponent opponent = Opponent.getInstance();

    @Test
    @DisplayName("1~9 임의의수 3개 생성 테스트")
    void generate3Number() {
        int baseballNumber = opponent.getBaseballNumber();

        assertThat((int) (Math.log10(baseballNumber))).isEqualTo(2);
    }
}
