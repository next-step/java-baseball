package nextstep.precourse.baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballUserInputNumberCompareTest {

    BaseballUserInputNumberCompare baseballUserInputNumberCompare = new BaseballUserInputNumberCompare();

    @Test
    void compareRightAndInputNumber() {

        int[] rightArray = {5, 3, 7};
        String[] inputNumberArray = {"6", "7", "1"};

        baseballUserInputNumberCompare.inputNumberCmpare(rightArray, inputNumberArray);

        assertEquals(baseballUserInputNumberCompare.strikeResult(1, 1), 1);
        assertEquals(baseballUserInputNumberCompare.ballResult(1, 2), 2);
    }
}