package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BallGame {

    private static final String PLAY_RESTART = "게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요 :  ";
    private static final Scanner scanner = new Scanner(System.in);

    public void play(BaseballResult baseballResult, List<Integer> computerNumbers) {
        do {
            baseballResult.initial();
            //2. get customer value
            InputNumber playerInputNumbersInitail = new InputNumber();
            String result = playerInputNumbersInitail.inputBallNumbers();
            List<Integer> playerInputNumbers = playerInputNumbersInitail.setBallNumber(result);

            baseballResult = getBallCount(baseballResult, computerNumbers, playerInputNumbers);

            ResultView resultView = new ResultView();
            resultView.printBallCountResult(baseballResult);

        } while (!baseballResult.isEndGame());
    }

    public BaseballResult getBallCount(BaseballResult baseballResult, List<Integer> dealerNumbers, List<Integer> playerInputNumbers) {
        for (int i = 0; i < dealerNumbers.size(); i++) {

            if (dealerNumbers.contains(playerInputNumbers.get(i))) {
                compareJudging(baseballResult, dealerNumbers.get(i), playerInputNumbers.get(i));
            }
        }

        return baseballResult;
    }

    private void compareJudging(BaseballResult baseballResult, Integer dealerString, Integer playerInputString) {

        if (dealerString.equals(playerInputString)) {
            baseballResult.isStrike();
            return;
        }
        baseballResult.isBall();
    }

    public static boolean restart() {
        System.out.println(PLAY_RESTART);
        System.out.println(PLAY_RESTART);
        String result = scanner.next();
        if (result.equals("1")) return true;
        if (result.equals("2")) return false;
        return false;
    }
}
