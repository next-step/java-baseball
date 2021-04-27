package baseball;

import exception.NotContinuedException;
import exception.NumberOnlyException;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        //1. get result
        BallGame baseBallGame = new BallGame();
        BaseballResult baseballResult = new BaseballResult();

        do {
            //2. get computer random value
            BallNumberRandom computerNumbersInitial = new BallNumberRandom();

            try {
                List<Integer> computerNumbers = computerNumbersInitial.getBallNumber();
                baseBallGame.play(baseballResult, computerNumbers);
            } catch (NotContinuedException notContinuedException){
                notContinuedException.getMessage();
            } catch (NumberOnlyException numberOnlyException){
                numberOnlyException.getMessage();
            }

        } while (baseBallGame.restart());
    }
}
