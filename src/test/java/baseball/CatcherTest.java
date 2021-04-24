package baseball;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatcherTest {
    Catcher catcher = new Catcher(GameController.BASEBALL_NUM_LENGTH);

    @Test
    @DisplayName("Strike 3, Ball 0")
    void checkScoreWithStrike3() {
        List<Integer> standardList = new ArrayList<>();
        standardList.add(1);
        standardList.add(2);
        standardList.add(3);
        catcher.setStandardNumbers(standardList);

        int[] pitchingNumbers = {1, 2, 3};
        catcher.setScore(pitchingNumbers);

        assertEquals(catcher.strikeCount, 3);
        assertEquals(catcher.ballCount, 0);
    }

    @Test
    @DisplayName("Strike 0, Ball 3")
    void checkScoreWithNBall3() {
        Catcher catcher = new Catcher(GameController.BASEBALL_NUM_LENGTH);

        List<Integer> standardList = new ArrayList<>();
        standardList.add(1);
        standardList.add(2);
        standardList.add(3);
        catcher.setStandardNumbers(standardList);

        int[] pitchingNumbers = {4, 5, 6};
        catcher.setScore(pitchingNumbers);

        assertEquals(catcher.strikeCount, 0);
        assertEquals(catcher.ballCount, 0);
    }

    @Test
    @DisplayName("Strike 1, Ball 1")
    void checkScoreWithNStrikeAndBall() {
        Catcher catcher = new Catcher(GameController.BASEBALL_NUM_LENGTH);

        List<Integer> standardList = new ArrayList<>();
        standardList.add(1);
        standardList.add(2);
        standardList.add(3);
        catcher.setStandardNumbers(standardList);

        int[] pitchingNumbers = {1, 3, 9};
        catcher.setScore(pitchingNumbers);

        assertEquals(catcher.strikeCount, 1);
        assertEquals(catcher.ballCount, 1);
    }

    @Test
    @DisplayName("Nothing")
    void checkScoreWithNothing() {
        List<Integer> standardList = new ArrayList<>();
        standardList.add(1);
        standardList.add(2);
        standardList.add(3);
        catcher.setStandardNumbers(standardList);

        int[] pitchingNumbers = {4, 5, 6};
        catcher.setScore(pitchingNumbers);

        assertEquals(catcher.strikeCount, 0);
        assertEquals(catcher.ballCount, 0);
    }
}
