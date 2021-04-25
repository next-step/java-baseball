import java.util.*;

public class GameNumber {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 3;
    public static final String MESSAGE_CONTAINS_ZERO = "숫자에 0을 포함해서는 안됩니다.";
    private static final Integer[] sourceNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final String MESSAGE_CONTAINS_DUPLICATION = "숫자가 중복되어서는 안됩니다.";
    private static final String MESSAGE_NOT_THREE_DIGIT = "세 자리 수만 입력할 수 있습니다.";
    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        this.gameNumber = gameNumber;
        validateGameNumber();
    }

    public static GameNumber randomGenerate() {
        List<Integer> sourceNumberList = Arrays.asList(sourceNumbers);
        Collections.shuffle(sourceNumberList);
        return new GameNumber(sourceNumberList.subList(FROM_INDEX, TO_INDEX));
    }

    public static GameNumber of(List<Integer> input) {
        return new GameNumber(input);
    }

    private void validateGameNumber() {
        validateThreeDigit();
        validateContainsZero();
        validateDuplication();
    }

    private void validateThreeDigit() {
        if (gameNumber.size() != 3) {
            throw new NotThreeDigitException(MESSAGE_NOT_THREE_DIGIT);
        }
    }

    private void validateDuplication() {
        Set<Integer> gameNumberSet = new HashSet<>(gameNumber);
        if (gameNumberSet.size() != 3) {
            throw new ContainsDuplicationException(MESSAGE_CONTAINS_DUPLICATION);
        }
    }

    private void validateContainsZero() {
        if (gameNumber.contains(0)) {
            throw new ContainsZeroException(MESSAGE_CONTAINS_ZERO);
        }
    }
}
