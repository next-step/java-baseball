package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import common.StringToNumberList;

class NumbersTest {

    @Test
    @DisplayName("스트라이 카운트크")
    void countSamPosiAndNum() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(StringToNumberList.transform("713"));
        Numbers numbers = StringToNumberList.transform("123");

        //when
        int result = winningNumbers.getStrike(numbers);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 카운트")
    void countSamNum() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(StringToNumberList.transform("713"));
        Numbers numbers = StringToNumberList.transform("127");

        //when
        int result = winningNumbers.getBall(numbers);

        //then
        assertThat(result).isEqualTo(2);
    }


}