package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private Hitter hitter;

    public BaseballGame(Hitter hitter) {
        this.hitter = hitter;
    }

    public void start(){
        Referee referee = new Referee(this.hitter);
        OutputView outputView;
        InputView inputView = new InputView();
        boolean gameOver = false;
        while(!gameOver){
            int inputNumber = inputView.printInputNumber();
            gameOver = referee.check(new Numbers(inputNumber));
            outputView = new OutputView(referee.strike(), referee.ball());
            outputView.printResult();
        }


    }

}
