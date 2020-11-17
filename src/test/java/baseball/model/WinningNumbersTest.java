package baseball.model;

import baseball.util.StringToNumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    @DisplayName("입력에 맞는 스트라이크 출력")
    public void getStrike() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(StringToNumberList.transform("713"));
        Numbers numbers = StringToNumberList.transform("123");

        //when
        int result = winningNumbers.getStrike(numbers);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력에 맞는 볼 출력")
    void getBall() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(StringToNumberList.transform("713"));
        Numbers numbers = StringToNumberList.transform("123");

        //when
        int result = winningNumbers.getBall(numbers);

        //then
        assertThat(result).isEqualTo(1);
    }
}