package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Hitter;
import baseball.domain.Numbers;
import baseball.domain.RandomNumber;
import baseball.view.InputView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int inputNumber = inputView.printInputNumber();

        RandomNumber randomNumber = new RandomNumber();
        Numbers hitterNumbers = new Numbers(randomNumber.createRandomNumber());
        Hitter hitter = new Hitter(hitterNumbers);

        BaseballGame baseballGame = new BaseballGame(hitter);
        baseballGame.start();

    }
}
