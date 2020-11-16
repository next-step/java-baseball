package com.nextstep.baseball;

import com.netxstep.baseball.BaseBall;
import com.netxstep.baseball.domain.Result;
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

        Map<Integer, Integer> answer = baseBall.getAnswerMap();

        Assertions.assertEquals(answer.keySet().size(), 3);
    }

    @Test
    void inputAnswer() {
        BaseBall baseBall = new BaseBall();
        baseBall.inputAnswer("123");

        Assertions.assertEquals(baseBall.getInputList().size(), 1);

        BusinessException exceptionLength = Assertions.assertThrows(BusinessException.class, () -> baseBall.inputAnswer("1234"));
        BusinessException exceptionValue = Assertions.assertThrows(BusinessException.class, () -> baseBall.inputAnswer("333"));
        BusinessException exceptionType = Assertions.assertThrows(BusinessException.class, () -> baseBall.inputAnswer("AAA"));

        Assertions.assertEquals(exceptionLength.getCode(), BusinessError.INVALID_VALUE_LENGTH.name());
        Assertions.assertEquals(exceptionValue.getCode(), BusinessError.INVALID_VALUE.name());
        Assertions.assertEquals(exceptionType.getCode(), BusinessError.INVALID_VALUE.name());
    }

    @Test
    void check() {
        BaseBall baseBall = new BaseBall();

        BusinessException exceptionNotInput = Assertions.assertThrows(BusinessException.class, baseBall::check);

        Assertions.assertEquals(exceptionNotInput.getCode(), BusinessError.INVALID_VALUE_LENGTH.name());

        baseBall.inputAnswer("123");
        Result result = baseBall.check();

        Assertions.assertNotNull(result);
    }

    @Test
    void print() {
        BaseBall baseBall = new BaseBall();

        Assertions.assertEquals(baseBall.print(new Result(3, 0)), "승리하였습니다. 시도횟수: 0");
        Assertions.assertEquals(baseBall.print(new Result(2, 1)), "스트라이크: 2, 볼: 1");
        Assertions.assertEquals(baseBall.print(new Result(0, 2)), "볼: 2");
        Assertions.assertEquals(baseBall.print(new Result(0, 0)), "낫싱!");
    }
}
