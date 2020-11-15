package domain;

import java.util.*;

public class GameDigitRepository {
    private static final Random random = new Random();
    private static final List<GameDigit> cachedDigits;


    static {
        cachedDigits = new ArrayList<>();
        for (int i = GameDigit.MIN_DIGIT; i <= GameDigit.MAX_DIGIT; i++) {
            cachedDigits.add(new GameDigit(i));
        }
    }

    private GameDigitRepository() {

    }

    public static List<GameDigit> getNotDuplicateGameDigits(int length) {
        Set<GameDigit> gameDigits = new HashSet<>();
        gameDigits.add(getRandomExceptZero());
        while (gameDigits.size() != length) {
            gameDigits.add(GameDigitRepository.getRandom());
        }
        return new ArrayList<>(gameDigits);
    }

    public static List<GameDigit> getDigitsByRaw(String raw) {
        List<GameDigit> gameDigits = new ArrayList<>();
        for (int i = 0; i < raw.length(); i++) {
            int numericValue = Character.getNumericValue(raw.charAt(i));
            GameDigit gameDigit = cachedDigits.get(numericValue);
            gameDigits.add(gameDigit);
        }
        return gameDigits;
    }

    private static GameDigit getRandom() {
        return cachedDigits.get(getRandomIntSingleDigit());
    }

    private static GameDigit getRandomExceptZero() {
        return cachedDigits.get(getRandomIntSingleDigitExceptZero());
    }

    private static int getRandomIntSingleDigit() {
        return random.nextInt(10);
    }

    private static int getRandomIntSingleDigitExceptZero() {
        return random.nextInt(9) + 1;
    }
}
