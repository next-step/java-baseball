package com.baseballgame.test.util;

import com.baseballgame.util.ComUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComUtilTest {

    @DisplayName("컴퓨터 숫자 발생테스트")
    @Test
    void generateTargetNum() {
        ComUtil comUtil = new ComUtil();
        List<String> testList = comUtil.generateTargetNum();
        assertThat(testList)
                .isNotEmpty()
                .doesNotContain("0")
                .hasSize(3);
    }
}
