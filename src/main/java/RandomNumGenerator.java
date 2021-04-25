import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumGenerator {
    private static int maxLen;
    private static int BASEBALL_MAX_NUM = 9;

    public RandomNumGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }
    public RandomNumGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public String generateRandomNum(){
        List<Integer> baseballRandomNums = createRandomNum();
        Collections.shuffle(baseballRandomNums);
        return getStringWhichIsConvertedList(pickNumbers(baseballRandomNums));
    }

    private static List<Integer> createRandomNum() {
        List<Integer> baseballNums = new ArrayList<>();
        for(int i = 1; i <= BASEBALL_MAX_NUM; i++){
            baseballNums.add(i);
        }
        return baseballNums;
    }

    private static List<Integer> pickNumbers(List<Integer> baseballNums) {
        return baseballNums.subList(0, maxLen);
    }

    private static String getStringWhichIsConvertedList(List<Integer> baseballNums) {
        StringBuilder builder = new StringBuilder();
        for (Integer i : baseballNums) {
            builder.append(i);
        }
        return builder.toString();
    }
}
