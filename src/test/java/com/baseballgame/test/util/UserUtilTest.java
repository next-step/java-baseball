package com.baseballgame.test.util;

import com.baseballgame.util.UserUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserUtilTest {

    @DisplayName("사용자 입력값 배열로 만들기")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2,3,ㅇ)ㅇ","(1,2,3)","1,2,333"})
     void changeStringToArray(String input) {
        UserUtil userUtil = new UserUtil();
        List<String> testList = userUtil.changeStringToArray(input);
        assertThat(testList)
                .isNotEmpty()
                .hasSize(3)
                .contains("2")
                .doesNotContainNull()
                .doesNotContain("(")
                .containsSequence("1", "2")
                .containsExactly("1","2","3");
    }


}
