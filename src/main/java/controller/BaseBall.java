package controller;

import domain.Ball;
import domain.Fail;
import domain.Strike;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    public static int baseBallGame(List<Integer> randomNumber) {
        Integer resetGame = null;
        while (resetGame == null) {
            List<Integer> input = getInput();

            int strikeNum = Ball.getInstance().checkCount(input, randomNumber);
            int ballNum = Strike.getInstance().checkCount(input, randomNumber);

            resetGame = playGame(strikeNum, ballNum);
        }

        return resetGame;
    }

    private static Integer playGame(int strikeNum, int ballNum) {
        if (Fail.getInstance().isRule(strikeNum, ballNum) || Ball.getInstance().isRule(strikeNum, ballNum)
                || Strike.getInstance().isRule(strikeNum, ballNum)) return null;

        if (strikeNum == 3) {
            ResultView.endGame();
            return InputView.resetGame();
        }

        ResultView.printStrikeAndBall(strikeNum, ballNum);
        return null;
    }

    private static List<Integer> getInput() {
        int inputNum = InputView.readInt();
        if (inputNum > 999 || inputNum <= 0) {
            return null;
        }

        List<Integer> input = new ArrayList<>();
        input.add(inputNum / 100);
        input.add((inputNum % 100) / 10);
        input.add(inputNum % 10);
        return input;
    }
}
