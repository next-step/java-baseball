package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.GameDigitRepository.getNotDuplicateThreeGameNumbers;

public class GameNumber {
    private final List<GameDigit> digits;

    public GameNumber(List<GameDigit> gameDigits) {
        validate(gameDigits);
        this.digits = gameDigits;
    }

    public static GameNumber generateRandomGameNumber() {
        List<GameDigit> numbers = getNotDuplicateThreeGameNumbers();
        return new GameNumber(numbers);
    }

    public static GameNumber ofByRaw(String userNumberRaw) {
        List<GameDigit> gameDigits = GameDigitRepository.getDigitsByRaw(userNumberRaw);
        return new GameNumber(gameDigits);
    }

    private static void validate(List<GameDigit> numbers) {
        validateHasThreeLength(numbers);
        validateDuplication(numbers);
    }

    private static void validateHasThreeLength(List<GameDigit> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리 수여야 합니다.");
        }
    }

    private static void validateDuplication(List<GameDigit> numbers) {
        Set<GameDigit> set = new HashSet<>(numbers);
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
        }
    }

    public MatchType judgeMatchType(GameDigit compareDigit, int originDigitIndex) {
        GameDigit originDigit = digits.get(originDigitIndex);
        if (originDigit.equals(compareDigit)) {
            return MatchType.STRIKE;
        }
        if (digits.contains(compareDigit)) {
            return MatchType.BALL;
        }
        return MatchType.NO_MATCH;
    }

    public int size() {
        return digits.size();
    }

    public GameDigit get(int index) {
        return digits.get(index);
    }
}
