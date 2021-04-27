package baseball;

import java.util.List;

public class BallGame {

    private static InputNumber playerInputNumbers;

    public void play(BaseballResult baseballResult, List<Integer> computerNumbers, List<Integer> playerInputNumbers) {

        baseballResult = getBallCount(baseballResult, computerNumbers, playerInputNumbers);
        System.out.println(baseballResult.resultPrint());
    }

    public BaseballResult getBallCount(BaseballResult baseballResult, List<Integer> dealerNumbers, List<Integer> playerInputNumbers) {
        for (int i = 0; i < dealerNumbers.size(); i++) {

            if (dealerNumbers.contains(playerInputNumbers.get(i))) {
                compareJudging(baseballResult, dealerNumbers, playerInputNumbers.get(i), i);
            }
        }

        return baseballResult;
    }

    private void compareJudging(BaseballResult baseballResult, List<Integer> dealerNumbers, Integer playerInputString, Integer i) {
        if (dealerNumbers.indexOf(playerInputString) == i) {
            baseballResult.isStrike();
            return;
        }
        baseballResult.isBall();
    }
}
