package domain;

import ui.InputView;
import ui.ResultView;

public class BaseballGame {
    private static final int GO_BUTTON = 1;
    private MatchMachine matchMachine;
    private int gameButton;

    public BaseballGame() {
        this.gameButton = GO_BUTTON;
    }

    public void play() {
        while (!isStop()) {
            generateMachine();
            playOneGame();
            inputButton();
        }
    }

    private void generateMachine() {
        this.matchMachine = new MatchMachine(new ComputerNumber().getNumbers());
    }

    private void playOneGame() {
        Score score = new Score();
        while (!score.isAllStrike()) {
            score = compareNumber();
            ResultView.printScore(score);
        }
        ResultView.endMessage();
    }

    private Score compareNumber() {
        return matchMachine.compare(new BaseballNumber(InputView.inputNumber()).getNumbers());
    }

    private void inputButton() {
        this.gameButton = InputView.restartOrEnd();
    }

    private boolean isStop() {
        return gameButton != GO_BUTTON;
    }
}
