package com.woowahan.pro.opponent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerOpponentTest {
    private Opponent opponent;

    @BeforeEach
    public void init() {
        opponent = new ComputerOpponent();
    }

    @Test
    @DisplayName("랜덤 숫자 3자리 검사")
    public void createRandomNumberNumberOfDigit() {
        //given

        //when
        String[] randomNumbers = opponent.createRandomNumber();

        //then
        assertThat(randomNumbers).hasSize(3);
    }

    @Test
    @DisplayName("랜덤 숫자 1~9 범위 검사")
    public void createRandomNumberRange() {
        //given

        //when
        String[] randomNumbers = opponent.createRandomNumber();

        //then
        assertThat(ComputerOpponent.RANDOM_NUMBER_RANGE).contains(randomNumbers);
    }
}
