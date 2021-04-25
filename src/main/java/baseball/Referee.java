package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static baseball.constant.Constant.NUMBERS_LIMIT;

public class Referee {
    protected final Numbers enemyNumbers;

    public Referee() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < NUMBERS_LIMIT; i++) {
            generateRandomWithoutDuplicate(randomList);
        }
        this.enemyNumbers = new Numbers(randomList);
    }

    public List<Integer> decide(List<Integer> playerNumbersList) {
        List<Integer> decideList = new ArrayList<>();
        decideList.add(enemyNumbers.strike(playerNumbersList));
        decideList.add(enemyNumbers.ball(playerNumbersList));
        return decideList;
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
