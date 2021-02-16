package controller;

import domain.BallCount;
import domain.BallNumbers;
import domain.Computer;
import view.InputView;
import view.OutputView;

public class BaseballGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Boolean START = true;

    public void play() {
        while (START) {
            Computer computer = new Computer();
            BallNumbers answerNumbers = computer.generateRandomNumbers();
            doGuess(new BallCount(), answerNumbers);
            outputView.printComplete();
            START = inputView.askForRestart();
        }
    }

    public void doGuess(BallCount ballCount, BallNumbers answerNumbers) {
        final int DONE = 3;
        while (!ballCount.isDone(DONE)) {
            askGuessInput(ballCount, answerNumbers);
        }
    }

    private void askGuessInput(BallCount ballCount, BallNumbers answerNumbers) {
        try {
            BallNumbers guessNumbers = BallNumbers.of(inputView.getGuessNumbers());
            outputView.printResult(answerNumbers.match(ballCount, guessNumbers));
        } catch (IllegalArgumentException e) {
            outputView.printError();
        }
    }
}
