package com.woowa.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setup() {
        referee = new Referee();
        referee.setNumber("123");
    }

    @ParameterizedTest
    @DisplayName("strike check test")
    @CsvSource(value = {"123:3", "132:1", "321:1", "213:1", "456:0", "789:0"}, delimiter = ':')
    void strikeTest(String input, int expected) {
        Assertions.assertThat(referee.checkStrike(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("ball check test")
    @CsvSource(value = {"123:0", "142:1", "421:1", "413:1", "132:2", "321:2", "213:2", "456:0", "789:0"}, delimiter = ':')
    void ballTest(String input, int expected) {
        Assertions.assertThat(referee.checkBall(input)).isEqualTo(expected);
    }

}
