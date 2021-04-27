package domain;

import view.ResultView;

import java.util.List;

public class Ball extends GameRule {

    private static Ball instance = new Ball();

    public static Ball getInstance() {
        return instance;
    }

    public boolean isRule(int strikeNum, int ballNum) {
        if (strikeNum == 0) {
            ResultView.printBall(ballNum);
            return true;
        }
        return false;
    }

    @Override
    protected int calculateCount(List<Integer> input, List<Integer> randomNumber, int count, int i) {
        if (input.contains(randomNumber.get(i)) && !input.get(i).equals(randomNumber.get(i))) {
            count++;
        }
        return count;
    }
}
