package domain;

import view.ResultView;

import java.util.List;

public abstract class GameRule {
    public int checkCount(List<Integer> input, List<Integer> randomNumber) {
        int count = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            count = calculateCount(input, randomNumber, count, i);
        }

        return count;
    }

    public abstract boolean isRule(int strikeNum, int ballNum);

    protected int calculateCount(List<Integer> input, List<Integer> randomNumber, int count, int i) {
        return 0;
    }
}
