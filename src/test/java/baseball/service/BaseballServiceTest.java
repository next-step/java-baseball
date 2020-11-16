package baseball.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballServiceTest {
    BaseballService baseballService = new BaseballService();

    @Test
    @DisplayName("숫자문자열을 나눠서 int 배열에 담기")
    void divideInputNum() {
        //given
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

    @Test
    @DisplayName("중복 없는 3개 숫자 생성")
    void setComputerNums() {
        //given
        Set<Integer> set;

        //when
        //then
        for (int i = 0; i < 100; i++) {
            set = new HashSet<>();
            int[] inputNums = baseballService.setComputerNums();

            for (int num : inputNums) {
                set.add(num);
            }
            assertEquals(set.size(), 3);
        }
    }
}
