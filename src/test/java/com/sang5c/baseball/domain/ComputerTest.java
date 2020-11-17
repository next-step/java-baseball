package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @DisplayName("랜덤으로 Baseball 정상 생성")
    @Test
    public void randomNumbers() {
        assertThat(Computer.randomBaseball()).isInstanceOf(Baseball.class);
    }

}
