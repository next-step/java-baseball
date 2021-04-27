package numberBaseball.domain;

import numberBaseball.dto.ResultResponse;
import numberBaseball.exception.ContainsDuplicationException;
import numberBaseball.exception.NotSourceNumberException;
import numberBaseball.exception.NotThreeDigitException;

import java.util.*;

public class GameNumber {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 3;
    public static final String MESSAGE_CONTAINS_ZERO = "숫자에 0을 포함해서는 안됩니다.";
    public static final int NUMBER_SIZE = 3;
    public static final int EXCLUDING_NUMBER = 0;
    public static final String MESSAGE_NOT_SOURCE_NUMBER = "1-9 사이의 정수만 입력할 수 있습니다.";
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
        validateSourceNumber();
        validateThreeDigit();
        validateDuplication();
    }

    private void validateSourceNumber() {
        if (!Arrays.asList(sourceNumbers).containsAll(gameNumber)) {
            throw new NotSourceNumberException(MESSAGE_NOT_SOURCE_NUMBER);
        }
    }

    private void validateThreeDigit() {
        if (gameNumber.size() != NUMBER_SIZE) {
            throw new NotThreeDigitException(MESSAGE_NOT_THREE_DIGIT);
        }
    }

    private void validateDuplication() {
        Set<Integer> gameNumberSet = new HashSet<>(gameNumber);
        if (gameNumberSet.size() != NUMBER_SIZE) {
            throw new ContainsDuplicationException(MESSAGE_CONTAINS_DUPLICATION);
        }
    }

    public MatchResult computeMatchResult(GameNumber target) {
        int strikes = getStrikes(target);
        int balls = getBalls(target);
        return new MatchResult(strikes, balls);
    }

    private int getBalls(GameNumber target) {
        int balls = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            ArrayList<Integer> indexRemovedGameNumber = new ArrayList<>(gameNumber);
            indexRemovedGameNumber.remove(i);
            balls = addBall(target, balls, i, indexRemovedGameNumber);
        }
        return balls;
    }

    private int addBall(GameNumber target, int balls, int i, ArrayList<Integer> indexRemovedGameNumber) {
        if (indexRemovedGameNumber.contains(target.gameNumber.get(i))) {
            balls++;
        }
        return balls;
    }

    private int getStrikes(GameNumber target) {
        int strikes = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            strikes = addStrike(target, strikes, i);
        }
        return strikes;
    }

    private int addStrike(GameNumber target, int strikes, int i) {
        if (gameNumber.get(i).equals(target.gameNumber.get(i))) {
            strikes++;
        }
        return strikes;
    }

    public ResultResponse getResultResponse(GameNumber inputGameNumber) {
        MatchResult matchResult = this.computeMatchResult(inputGameNumber);
        return matchResult.MatchResultToResponse();
    }

}
