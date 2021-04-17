package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public List<Integer> makeRandomNumberList() {
        List<Integer> randomNumList = new ArrayList<Integer>();
        while(randomNumList.size() < 3) {
            int randomNum = makeRandomNumber();
            if (!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }
        return randomNumList;
    }
}
