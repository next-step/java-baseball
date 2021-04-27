package nextstep.precourse.baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballStrikeCheckTest {

    BaseballStrikeCheck baseballStrikeCheck = new BaseballStrikeCheck();

    @Test
    void strikeCheck() {
        assertTrue(baseballStrikeCheck.baseballStrikeLoopCheck(0));

    }

}