package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.util.BaseballValid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class ComputerTest {

    @Test
    void computerDuplicationValid_test() {
        Computer computer = new Computer();
        BaseballValid baseballValid = new BaseballValid();
        String ballNumber = computer.getBallNumber();
        boolean baseballDuplicateValid = baseballValid.isBaseballDuplicateValid(ballNumber);
        boolean baseballLengthValid = baseballValid.isBaseballLengthValid(ballNumber);
        boolean baseballTextValid = baseballValid.isBaseballTextValid(ballNumber);
        assertAll(
                () -> assertEquals(true, baseballDuplicateValid),
                () -> assertEquals(true, baseballLengthValid),
                () -> assertEquals(true, baseballTextValid)
        );

    }

}