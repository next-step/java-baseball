package domain;

import java.util.*;

public class GameDigitRepository {
    private static final Random random = new Random();
    private static final List<GameDigit> cachedNumbers;

    static {
        cachedNumbers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            cachedNumbers.add(new GameDigit(i));
        }
    }

    private GameDigitRepository() {

    }

    public static List<GameDigit> getNotDuplicateThreeGameNumbers() {
        Set<GameDigit> gameDigits = new HashSet<>();
        gameDigits.add(getFirstRandomNumber());
        while (gameDigits.size() != 3) {
            gameDigits.add(GameDigitRepository.getRandomNumber());
        }
        return new ArrayList<>(gameDigits);
    }

    public static List<GameDigit> getDigitsByRaw(String raw) {
        List<GameDigit> gameDigits = new ArrayList<>();
        for (int i = 0; i < raw.length(); i++) {
            int numericValue = Character.getNumericValue(raw.charAt(i));
            GameDigit gameDigit = cachedNumbers.get(numericValue);
            gameDigits.add(gameDigit);
        }
        return gameDigits;
    }

    private static GameDigit getRandomNumber() {
        return cachedNumbers.get(getRandomIntSingleDigit());
    }

    private static GameDigit getFirstRandomNumber() {
        return cachedNumbers.get(getRandomIntSingleDigitExceptZero());
    }

    private static int getRandomIntSingleDigit() {
        return random.nextInt(10);
    }

    private static int getRandomIntSingleDigitExceptZero() {
        return random.nextInt(9) + 1;
    }
}
