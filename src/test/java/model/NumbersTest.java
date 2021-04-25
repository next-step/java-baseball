package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import common.StringToNumberList;

class NumbersTest {

    @Test
    @DisplayName("같은 포지션과 숫자를 카운트")
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
    @DisplayName("같은 숫자 카운트")
    void countSamNum() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(StringToNumberList.transform("713"));
        Numbers numbers = StringToNumberList.transform("123");

        //when
        int result = winningNumbers.getStrike(numbers);

        //then
        assertThat(result).isEqualTo(2);
    }
}