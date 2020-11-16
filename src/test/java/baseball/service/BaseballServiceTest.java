package baseball.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballServiceTest {
    @Test
    @DisplayName("숫자문자열을 나눠서 int 배열에 담기")
    void divideInputNum() {
        //given
        BaseballService baseballService = new BaseballService();
        String strNum = "157";

        //when
        int[] inputNums = baseballService.divideInputNum(strNum);

        //then
        Assertions.assertAll("inputNums",
                () -> assertEquals(inputNums[0], 1),
                () -> assertEquals(inputNums[1], 5),
                () -> assertEquals(inputNums[2], 7)
        );
    }
}
