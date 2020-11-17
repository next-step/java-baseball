package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBallNumbers {

    private static final int INITIAL_COUNT = 0;
    private static final int LAST_COUNT = 3;

    private List<BaseBallNumber> numbers = new ArrayList<>();

    public BaseBallNumbers (BaseBallNumberGenerator baseBallNumberGenerator) {
        numbers.addAll(baseBallNumberGenerator.getNumbers());
    }

    public static int findStrikeCount(BaseBallNumbers computer, BaseBallNumbers player) {
        int strikeCount = 0;
        for (int i = INITIAL_COUNT; i < LAST_COUNT; i++) {
            strikeCount += matchStrikeNumber(computer.getBaseBallNumber(i), player.getBaseBallNumber(i));
        }
        return strikeCount;
    }

    private static int matchStrikeNumber(BaseBallNumber computerBallNumber, BaseBallNumber playerBallNumber) {
        if(computerBallNumber.compareTo(playerBallNumber) == 0) {
            return 1;
        }
        return 0;
    }

    public static int fineBallCount(BaseBallNumbers computer, BaseBallNumbers player) {
        int ballCount = 0;
        for (int i = INITIAL_COUNT; i < LAST_COUNT; i++) {
            ballCount += matchBallNumber(computer, player, i);
        }
        return ballCount;
    }

    private static int matchBallNumber(BaseBallNumbers computer, BaseBallNumbers player, int index) {
        if(computer.getBaseBallNumber(index).compareTo(player.getBaseBallNumber(index)) != 0
                && computer.numbers.contains(player.getBaseBallNumber(index))){
            return 1;
        }
        return 0;
    }

    public BaseBallNumber getBaseBallNumber(int index) {
        return numbers.get(index);
    }

    public List<BaseBallNumber> getBaseBallNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
