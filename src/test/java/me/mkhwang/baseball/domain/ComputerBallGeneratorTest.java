package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.util.BaseballValid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class ComputerBallGeneratorTest extends BaseballValid{

    @Test
    void computerDuplicationValid_test() {
        ComputerBallGenerator computer = new ComputerBallGenerator();
        String ballNumber = computer.getBallNumber();
        boolean baseballDuplicateValid = isBaseballDuplicateValid(ballNumber);
        boolean baseballLengthValid = isBaseballLengthValid(ballNumber);
        boolean baseballTextValid = isBaseballTextValid(ballNumber);
        assertAll(
                () -> assertEquals(true, baseballDuplicateValid),
                () -> assertEquals(true, baseballLengthValid),
                () -> assertEquals(true, baseballTextValid)
        );

    }

}