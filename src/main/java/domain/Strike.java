package domain;

import view.ResultView;

import java.util.List;

public class Strike extends GameRule {

    private static Strike instance = new Strike();

    public static Strike getInstance() {
        return instance;
    }

    public boolean isRule(int strikeNum, int ballNum) {
        if (ballNum == 0) {
            ResultView.printStrike(strikeNum);
            return true;
        }
        return false;
    }

    @Override
    protected int calculateCount(List<Integer> input, List<Integer> randomNumber, int count, int i) {
        if (input.get(i).equals(randomNumber.get(i))) {
            count++;
        }
        return count;
    }
}
