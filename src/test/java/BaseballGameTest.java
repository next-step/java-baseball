import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    @Test
    public void isRandomNumberValid(){
        BaseballGame game = new BaseballGame();
        int []arr = game.getRandomArr();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
          set.add(arr.length);
        }
        assertEquals(3, set.size());
    }

    @Test
    public void isNumberToArrCorrect(){
        BaseballGame game = new BaseballGame();
        int []res = game.numberToArr(012);

        assertEquals(res[0], 0);
        assertEquals(res[1], 1);
        assertEquals(res[2], 2);
    }
    @Test
    public void isCheckConditionCorrect(){
        BaseballGame game = new BaseballGame();

        int strikeCnt = 2;
        int duplicateCnt = 3;
        boolean result = game.checkCondition(strikeCnt, duplicateCnt);
        assertEquals(true, result);

        strikeCnt = 3;
        duplicateCnt = 3;
        result = game.checkCondition(strikeCnt, duplicateCnt);
        assertEquals(false, result);
    }
}
