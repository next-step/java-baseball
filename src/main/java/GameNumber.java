import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameNumber {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 3;
    public static final String MESSAGE_CONTAINS_ZERO = "숫자에 0을 포함해서는 안됩니다.";
    private static final Integer[] sourceNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
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
        validateContainsZero();
    }

    private void validateContainsZero() {
        if (gameNumber.contains(0)) {
            throw new ContainsZeroException(MESSAGE_CONTAINS_ZERO);
        }
    }
}
