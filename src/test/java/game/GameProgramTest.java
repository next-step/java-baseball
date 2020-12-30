package game;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import common.GameGuidePhrases;
import common.GameMode;
import common.GameOption;
import exception.GameInputInvalidException;
import exception.ReplayInputOutBoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameProgramTest {

    private GameProgram gameProgram;
    private List<String> inputArrayList;

    @BeforeAll
    void init() {
        gameProgram = new GameProgram();
        gameProgram.initProgram();

        inputArrayList = new ArrayList<>();
        inputArrayList.add("1");
        inputArrayList.add("2");
        inputArrayList.add("3");
    }

    @Test
    void checkInputValid_differentNumberArray() throws Exception {
        Method method = gameProgram.getClass().getDeclaredMethod("checkInputValid", List.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(gameProgram, inputArrayList));
    }

    @Test
    void isGameEndStatus_threeStrike() throws Exception  {
        GameScoreInfo gameScoreInfo = new GameScoreInfo();
        gameScoreInfo.setStrikeCount(3);

        Method method = gameProgram.getClass().getDeclaredMethod("isGameEndStatus", GameScoreInfo.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(gameProgram, gameScoreInfo));
    }

    @Test
    void isGameEndStatus_oneStrike() throws Exception  {
        GameScoreInfo gameScoreInfo = new GameScoreInfo();
        gameScoreInfo.setStrikeCount(1);

        Method method = gameProgram.getClass().getDeclaredMethod("isGameEndStatus", GameScoreInfo.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(gameProgram, gameScoreInfo));
    }

}