package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static baseball.constant.Constant.*;

public class Referee {
    protected final Numbers enemyNumbers;

    public Referee() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < NUMBERS_LIMIT; i++) {
            generateRandomWithoutDuplicate(randomList);
        }
        this.enemyNumbers = new Numbers(randomList);
        System.out.println("this.enemyNumbers = " + this.enemyNumbers);
    }

    public List<Integer> decide(List<Integer> playerNumbersList) {
        List<Integer> decideList = new ArrayList<>();
        decideList.add(enemyNumbers.strike(playerNumbersList));
        decideList.add(enemyNumbers.ball(playerNumbersList));
        return decideList;
    }

    private void generateRandomWithoutDuplicate(List<Integer> randomList) {
        Random random = new Random();
        int randomNumber = random.nextInt(RANDOM_MAX_NUMBER - RANDOM_MIN_NUMBER + 1) + RANDOM_MIN_NUMBER;
        if (randomList.contains(randomNumber)) {
            generateRandomWithoutDuplicate(randomList);
        }
        System.out.println("randomNumber = " + randomNumber);
        randomList.add(randomNumber);
    }
}
