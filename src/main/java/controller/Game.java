package controller;

import domain.BaseBall;
import domain.JudgementCountPair;
import domain.Numbers;
import domain.RandomGenerator;
import view.Receipt;
import view.ResultView;

public class Game {

    public static final int GAME_WIN_STRIKE_COUNT = 3;

    public static void main(String[] args) {
        BaseBall baseBall = generateComputerBaseBall();

        playGames(baseBall);
    }

    private static void playGames(BaseBall baseBall) {
        while (true) {
            ResultView.printToInputNumbers();
            Numbers number = Receipt.receiptNumber();

            JudgementCountPair play = baseBall.play(number);

            Integer countOfStrike = play.retrieveCountOfStrike();
            ResultView.printCountOfStrikeIfExist(countOfStrike);

            Integer countOfBall = play.retrieveCountOfBall();
            ResultView.printCountOfBallIfExist(countOfBall);

            baseBall = checkReplayWhenThreeStrike(baseBall, countOfStrike);
        }
    }

    private static BaseBall checkReplayWhenThreeStrike(BaseBall baseBall, Integer countOfStrike) {
        if (isNotThreeStrike(countOfStrike)) {
            return baseBall;
        }

        ResultView.printGameOver();
        ResultView.printToInputWhetherToEndGameOrNot();

        boolean isReplay = Receipt.receiveValueWhetherToEndGameOrNot();

        if (isReplay) {
            return generateComputerBaseBall();
        }

        throw new IllegalStateException("게임이 종료되었습니다.");
    }

    private static BaseBall generateComputerBaseBall() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return new BaseBall(new Numbers(randomGenerator.generate()));
    }

    private static boolean isNotThreeStrike(Integer countOfStrike) {
        return countOfStrike != GAME_WIN_STRIKE_COUNT;
    }
}
