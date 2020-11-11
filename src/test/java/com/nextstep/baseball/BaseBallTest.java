package com.nextstep.baseball;

import com.netxstep.baseball.BaseBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BaseBallTest {

    @Test
    void generateAnswer() {
        BaseBall baseBall = new BaseBall();
        baseBall.generateAnswer();

        Map<Integer, Integer> answer = baseBall.getAnswer();

        Assertions.assertEquals(answer.keySet().size(), 3);
    }
}
