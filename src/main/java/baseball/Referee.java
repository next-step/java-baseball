package baseball;

import java.util.*;

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

    public Map<String, Integer> decide(List<Integer> playerNumbersList) {
        Map<String, Integer> playResult = new HashMap<>();
        int strike = enemyNumbers.strike(playerNumbersList);
        int ball = enemyNumbers.ball(playerNumbersList);
        playResult.put(STRIKE, strike);
        playResult.put(BALL, ball);
        return playResult;
    }

    private void generateRandomWithoutDuplicate(List<Integer> randomList) {
        Random random = new Random();
        int randomNumber = random.nextInt(RANDOM_MAX_NUMBER);
        if (randomList.contains(randomNumber) || randomNumber == 0) {
            generateRandomWithoutDuplicate(randomList);
        }
        System.out.println("randomNumber = " + randomNumber);
        randomList.add(randomNumber);
    }
}
