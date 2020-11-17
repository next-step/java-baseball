package com.demo.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballRunnerTest {

    BaseballRunner baseballRunner;

    public BaseballRunnerTest() {
        this.baseballRunner = new BaseballRunner();
    }

    @Test
    @DisplayName("printDecision을 통해 스트라이크가 3이 아닌 경우 계속 진행하기 위해 true가 나오는지 확인")
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
    @DisplayName("checkContinue를 통해서 1,2가 아닌 값을 넣었을 때 0이 나오는지 확인")
    public void checkContinue() {
        int checkContinue = this.baseballRunner.checkContinue("3");

        assertThat(checkContinue).isEqualTo(0);
    }
}