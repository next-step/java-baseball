package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static baseball.constant.Constant.NUMBERS_LIMIT;

public class Referee {
    protected final Numbers numbers;

    public Referee() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < NUMBERS_LIMIT; i++) {
            generateRandomWithoutDuplicate(randomList);
        }
        this.numbers = new Numbers(randomList);
    }

    private void generateRandomWithoutDuplicate(List<Integer> randomList) {
        Random random = new Random();
        int randomNumber = random.nextInt();
        if (randomList.contains(randomNumber)) {
            generateRandomWithoutDuplicate(randomList);
        }
        randomList.add(randomNumber);
    }
}
