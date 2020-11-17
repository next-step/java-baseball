package com.baseballgame.test.util;

import com.baseballgame.util.GameUtil;
import com.baseballgame.util.UserUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameUtilTest {

    @DisplayName("숫자배열 일치여부 확인")
    @ParameterizedTest
    @CsvSource(
            {"123, 123, true"
            ,"125, 425, false"
            ,"234, 236, false"}
    )
    void matchNumber(String input , String input2, boolean expected) {
        GameUtil gameUtil = new GameUtil();
        UserUtil userUtil = new UserUtil();
        List<String> testList = userUtil.changeStringToArray(input);
        List<String> expectedList = userUtil.changeStringToArray(input2);
        boolean test = gameUtil.matchNumber(testList , expectedList);
        assertEquals(expected,test);
    }

    @DisplayName("스트라이크, 볼 판정 구현 로직")
    @Test
    void assignBallType() {
        GameUtil gameUtil = new GameUtil();
        String [] userList = {"1","2","3"};
        String [] targetList = {"1","3","2"};

        Map<String, Object> testMap = gameUtil.assignBallType(Arrays.asList(userList) , Arrays.asList(targetList));
        assertThat(testMap)
                .isNotEmpty()
                .hasSize(2)
                .contains(entry("Ball",2), entry("Strike",1));
    }

}
