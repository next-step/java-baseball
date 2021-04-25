import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;


public class BaseBallGame {
    int[] generatedArray;
    int[] userArray;

    BaseBallGame() {
        generatedArray = new int[3];
        userArray = new int[3];
    }

    void generateNumber() {
        List<Integer> baseBallNum = new ArrayList<Integer>();
        for(int i = 1 ; i <= 9 ; i++) {
            baseBallNum.add(i);
        }
        Collections.shuffle(baseBallNum);
        for(int i = 0 ; i < 3 ; i++) {
            generatedArray[i] = baseBallNum.get(i);
        }

        return;
    }
}
