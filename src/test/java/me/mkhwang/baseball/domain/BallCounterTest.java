package me.mkhwang.baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class BallCounterTest {

    @Test
    void counter_noting_test() {
        BallCounter ballCounter = new BallCounter("123","456");
        assertEquals(true, ballCounter.isNoting());
    }

    @Test
    void counter_1st_1b_test() {
        BallCounter ballCounter = new BallCounter("157","351");
        assertAll(
                () -> assertEquals(1,ballCounter.getStrikeCount()),
                () -> assertEquals(1,ballCounter.getBallCount()),
                () -> assertEquals(false, ballCounter.isNoting())
        );
    }

}