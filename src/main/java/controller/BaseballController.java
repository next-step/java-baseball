package controller;

import domain.NumberSet;
import domain.State;
import util.RandomNumberUtil;
import view.InputView;
import view.OutputView;

public class BaseballController {

    public static final int NUMBER_SIZE = 3;
    public static final int GAME_OVER_CONDITION_STRIKE = 3;
    private State state = State.PLAY;
    private NumberSet systemNumbers;
    private NumberSet playerNumbers;

    public void startGame() {
        systemNumbers = RandomNumberUtil.getSystemNumber();
        while(state != State.END) {
            playGame();
        }
    }

    private void playGame() {
        playerNumbers = InputView.getPlayerInput();
        int strikeCnt = checkStrike();
        checkGameOver(strikeCnt);
        int ballCnt = checkBall() - strikeCnt;
        OutputView.checkGameStatus(ballCnt, strikeCnt);
    }

    private int checkStrike() {
        int strikeCnt = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if(playerNumbers.getNumbers().get(i).getNumber()
                == systemNumbers.getNumbers().get(i).getNumber()) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private void checkGameOver(int strikeCnt) {
        if (strikeCnt == GAME_OVER_CONDITION_STRIKE) {
            OutputView.printGameOver(strikeCnt);
            checkPlayerReplayAnswer();
        }
    }

    private void checkPlayerReplayAnswer() {
        if(InputView.getPlayerReplayInput() == State.PLAY) {
            systemNumbers = RandomNumberUtil.getSystemNumber();
        } else {
            state = State.END;
        }
    }

    private int checkBall() {
        return (int) playerNumbers.getNumbers().stream()
            .filter(playerNumber -> systemNumbers.getNumbers().stream()
                .anyMatch(systemNumber -> systemNumber.getNumber() == playerNumber.getNumber()))
            .count();
    }
}
