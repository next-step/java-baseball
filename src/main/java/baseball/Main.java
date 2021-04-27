package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Hitter;
import baseball.domain.Numbers;
import baseball.domain.RandomNumber;
import baseball.view.InputView;

public class Main {

    public static void main(String[] args) {


        RandomNumber randomNumber = new RandomNumber();
        InputView inputView = new InputView();
        int regameNumber = 1;
        while (regameNumber == 1) {
            Numbers hitterNumbers = new Numbers(randomNumber.createRandomNumber());
            Hitter hitter = new Hitter(hitterNumbers);

            BaseballGame baseballGame = new BaseballGame(hitter);
            baseballGame.start();

            regameNumber = inputView.printRegame();
        }

    }
}
