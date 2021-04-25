package com.bbidag.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Referee referee;
    private Computer computer;

    @BeforeEach
    public void setUp(){
        computer = new Computer(new Random(System.currentTimeMillis()));
        referee = new Referee(computer);
    }

    @Test
    @DisplayName("3 스트라이크 유무에 따라 승리 여부를 판단 테스트")
    public void isWinOrNot(){
        referee.setStrikeCount(0);
        assertThat(referee.applyWinOrNot()).isFalse();
        referee.setStrikeCount(3);
        assertThat(referee.applyWinOrNot()).isTrue();
    }

}
