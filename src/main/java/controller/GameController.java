package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import javax.xml.bind.UnmarshallerHandler;
import java.util.List;

public class GameController {
    InputView inputView;
    OutputView outputView;
    private Computer computer;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Game game = new Game();
        while (game.isRunning()) {
            gameInit();
            gameStart();
        }
    }

    private void gameInit() {
        computer = new Computer();
    }

    public void gameStart() {
        Round round = new Round();
        while (round.isNot3Strike()) {
            UserNumber userNumber = inputView.getUserNumbers();
            RoundResult roundResult = new RoundResult(userNumber.getNumbers(), computer.getNumbers());
            List<String> result = roundResult.getResult();
            round.setResult(result);
        }
    }
}
