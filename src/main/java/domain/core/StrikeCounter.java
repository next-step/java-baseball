package domain.core;

import java.util.List;

public class StrikeCounter {
    private final List<Integer> answer;

    private StrikeCounter(List<Integer> answer) {
        this.answer = answer;
    }

    public static StrikeCounter of(List<Integer> answer){
        return new StrikeCounter(answer);
    }

    public int getStrikeCount(List<Integer> input) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            strikeCount = checkStrike(input, index, strikeCount);
        }
        return strikeCount;
    }

    private int checkStrike(List<Integer> input, int index, int strikeCount) {
        if (answer.get(index).equals(input.get(index))) {
            strikeCount++;
        }
        return strikeCount;
    }
}
