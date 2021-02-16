package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Game game;
    private Computer computer;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        game = new Game();
    }

    public void play() {
        while (game.isRunning()) {
            gameInit(); // 컴퓨터의 번호 정하기
            gameStart(); // 사용자가 번호 맞추기
            askReplay(); // 게임 계속 할 것인지 묻기
        }
    }

    private void gameInit() {
        computer = new Computer();
    }

    public void gameStart() {
        Round round = new Round();
        while (round.isNot3Strike()) {
            playRound(round);
        }
        outputView.printFinishRound();
    }

    private void playRound(Round round) {
        UserNumber userNumber = inputView.getUserNumbers();
        RoundResult roundResult = new RoundResult(userNumber.getNumbers(), computer.getNumbers());
        List<String> result = roundResult.getResult();
        round.setResult(result);
        outputView.showResult(result);
    }

    private void askReplay() {
        game.setFinish(inputView.getMenu());
    }
}
