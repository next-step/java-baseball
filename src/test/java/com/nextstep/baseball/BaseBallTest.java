package com.nextstep.baseball;

import com.netxstep.baseball.BaseBall;
import com.netxstep.baseball.exception.BusinessError;
import com.netxstep.baseball.exception.BusinessException;
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

    @Test
    void inputAnswer() {
        BaseBall baseBall = new BaseBall();
        baseBall.inputAnswer(123);

        BusinessException exceptionLength = Assertions.assertThrows(BusinessException.class, () -> baseBall.inputAnswer(1234));
        BusinessException exceptionValue = Assertions.assertThrows(BusinessException.class, () -> baseBall.inputAnswer(333));

        Assertions.assertEquals(exceptionLength.getCode(), BusinessError.INVALID_VALUE_LENGTH.name());
        Assertions.assertEquals(exceptionValue.getCode(), BusinessError.INVALID_VALUE.name());
    }
}
