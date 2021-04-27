package baseball;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        //1. get result
        BallGame baseBallGame = new BallGame();
        BaseballResult baseballResult = new BaseballResult();

        do {
            //2. get computer random value
            BallNumberRandom computerNumbersInitial = new BallNumberRandom();
            List<Integer> computerNumbers = computerNumbersInitial.getBallNumber();

            System.out.println("랜덤값은 다음과 같다");
            System.out.println(computerNumbers);

            baseBallGame.play(baseballResult, computerNumbers);
        } while (baseBallGame.restart());
    }
}
