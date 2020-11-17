package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BaseballTest {
    private Baseball baseballTest = Baseball.getInstance();

    @Test
    public void testCheckStrikeOrBall() {
        final Result result = Result.getInstance();
        final List<Integer> guessList = new ArrayList<>(Arrays.asList(1, 2, 3));
        final int answerNumber = 3;
        final int answerNumberIndex = 0;

        baseballTest.checkStrikeOrBall(guessList, answerNumber, answerNumberIndex);

        assertEquals("1 볼 ", result.toString());
    }
}
