package com.sang5c.baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    public void randomBaseball() {
        assertThat(Computer.randomBaseball()).isInstanceOf(Baseball.class);
    }

}
