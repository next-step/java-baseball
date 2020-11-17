package com.demo.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballRunnerTest {

    BaseballRunner baseballRunner;

    public BaseballRunnerTest() {
        this.baseballRunner = new BaseballRunner();
    }

    @Test
    public void printDecision() {
        // given
        Decision decision = new Decision();
        decision.addStrike();
        decision.addCount();
        decision.addStrike();
        decision.addCount();
        decision.addCount();

        // when
        boolean returnDecision = this.baseballRunner.printDecision(decision);

        // then
        assertThat(returnDecision).isTrue();
    }

    @Test
    public void checkContinue() {
        int checkContinue = this.baseballRunner.checkContinue("3");

        assertThat(checkContinue).isEqualTo(0);
    }
}