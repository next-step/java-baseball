package controller;

import domain.Number;
import domain.NumberSet;
import domain.State;
import java.util.Arrays;
import java.util.stream.Collectors;
import util.RandomNumberUtil;
import view.InputView;
import view.OutputView;

public class BaseballController {

    private static State state = State.PLAY;
    public static final int NUMBER_SIZE = 3;
    public static final int GAME_OVER_CONDITION_STRIKE = 3;
    private static NumberSet systemNumbers;
    private static NumberSet playerNumbers;

    public void startGame() {
        initGame();
        while(state != State.END) {
            playGame();
        }
    }

    private void playGame() {
        playerNumbers = InputView.getPlayerInput();
        int strikeCnt = checkStrike();
        checkAnswer(strikeCnt);
        int ballCnt = checkBall() - strikeCnt;
        OutputView.checkGameStatus(ballCnt, strikeCnt);
    }

    private void initGame() {
        systemNumbers = new NumberSet(Arrays.stream(RandomNumberUtil.getDistinctNumber())
            .mapToObj(Number::new)
            .collect(Collectors.toList()));
    }

    private static int checkStrike() {
        int strikeCnt = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if(playerNumbers.getNumbers().get(i).getNumber() == systemNumbers.getNumbers().get(i).getNumber()) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private static void checkAnswer(int strikeCnt) {
        if (strikeCnt == GAME_OVER_CONDITION_STRIKE) {
            OutputView.printStrikeHint(strikeCnt);
            OutputView.printGameOver();
            checkPlayerReplayAnswer();
        }
    }

    private static void checkPlayerReplayAnswer() {
        int option = InputView.getPlayerReplayInput();
        if(option == State.PLAY.getOption()) {
            systemNumbers = new NumberSet(Arrays.stream(RandomNumberUtil.getDistinctNumber())
                .mapToObj(Number::new)
                .collect(Collectors.toList()));
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
