package baseball;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        //1. get computer random value
        BallNumberRandom computerNumbersInitial = new BallNumberRandom();
        List<Integer> computerNumbers = computerNumbersInitial.getBallNumber();

        //2. get customer value
        InputNumber playerInputNumbersInitail = new InputNumber();
        String result = playerInputNumbersInitail.inputBallNumbers();
        List<Integer> playerInputNumbers = playerInputNumbersInitail.setBallNumber(result);

        //3. result
        BaseballResult baseballResult = new BaseballResult();

        //   do {
            BallGame baseBallGame = new BallGame();
            baseBallGame.play(baseballResult, computerNumbers, playerInputNumbers);

    //    } while (InputNumber.restart());
    }
}
