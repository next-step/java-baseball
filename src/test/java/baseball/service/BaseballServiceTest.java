package baseball.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("중복 없는 숫자 생성")
    void getUniqueNum() {
        //given
        Set<Integer> set;

        //when
        //then
        for (int i = 0; i < 100; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                baseballService.getUniqueNum(set);
            }
            assertEquals(set.size(), 3);
        }
    }

    @Test
    @DisplayName("입력 숫자 모두 일치")
    void isAllMatch() {
        //given
        int[] compareNums = {3, 0, 0};
        int[] compareNums2 = {2, 0, 0};

        //when
        boolean check = baseballService.isAllMatch(compareNums);
        boolean check2 = baseballService.isAllMatch(compareNums2);

        //then
        assertTrue(check);
        assertFalse(check2);
    }

    @Test
    @DisplayName("입력 숫자 모두 불일치")
    void isNotAllMatch() {
        //given
        int[] compareNums = {0, 0, 2};
        int[] compareNums2 = {0, 1, 1};

        //when
        boolean check = baseballService.isNotAllMatch(compareNums);
        boolean check2 = baseballService.isNotAllMatch(compareNums2);

        //then
        assertTrue(check);
        assertFalse(check2);
    }

    @Test
    @DisplayName("입력 숫자 중 일치하는 숫자 있음")
    void isAnyMatch() {
        //given
        int[] compareNums = {1, 0, 2};
        int[] compareNums2 = {0, 0, 3};

        //when
        boolean check = baseballService.isAnyMatch(compareNums);
        boolean check2 = baseballService.isAnyMatch(compareNums2);

        //then
        assertTrue(check);
        assertFalse(check2);
    }
}
