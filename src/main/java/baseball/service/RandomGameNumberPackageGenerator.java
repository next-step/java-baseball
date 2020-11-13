package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberPackage;

import java.util.*;

import static baseball.domain.GameNumber.MAXIMUM_GAME_NUMBER;
import static baseball.domain.GameNumber.MINIMUM_GAME_NUMBER;

public class RandomGameNumberPackageGenerator implements GameNumberPackageGenerator {
    public static final int MINIMUM_INDEX = 0;
    public static final int MAXIMUM_INDEX = 2;

    private static final List<GameNumber> packageNumberPool = initPackageNumberPool();

    private static List<GameNumber> initPackageNumberPool() {
        List<GameNumber> gameNumbers = new ArrayList<>();

        for (int i = MINIMUM_GAME_NUMBER; i <= MAXIMUM_GAME_NUMBER; ++i) {
            gameNumbers.add(GameNumber.getInstance(i));
        }

        return gameNumbers;
    }

    @Override
    public GameNumberPackage generate() {
        return new GameNumberPackage(getBaseballNumbers());
    }

    private Map<GameNumber, Integer> getBaseballNumbers() {
        Collections.shuffle(packageNumberPool);

        Map<GameNumber, Integer> baseballNumbers = new HashMap<>();

        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; ++i) {
            baseballNumbers.put(packageNumberPool.get(i), i);
        }

        return baseballNumbers;
    }
}
