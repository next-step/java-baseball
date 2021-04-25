package baseball;

import java.util.Scanner;

public class BaseballGame {
    private Scanner scanner = new Scanner(System.in);
    private Baseball baseball = new Baseball();
    private String answerNumberString;
    private boolean finishGame = false;
    private boolean foundCorrectAnswer;

    public void startGame() {
        answerNumberString = baseball.makeBaseballNumberString();

        foundCorrectAnswer = false;
        while (!foundCorrectAnswer) {
            System.out.print("숫자를 입력해주세요 : ");
            int inputNumber = scanner.nextInt();

            this.judgeInputNumber(inputNumber);
        }
    }

    private void judgeInputNumber(int inputNumber) {
        if (baseball.isValidBaseballInputNumber(inputNumber)) {
            int strikes = baseball.countStrikes(answerNumberString, Integer.toString(inputNumber));
            int balls = baseball.countBalls(answerNumberString, Integer.toString(inputNumber));

            String result = baseball.makeComparisonResultString(new BaseballComparisonResult(strikes, balls));
            System.out.println(result);
            checkStrikeAll(strikes);
        }
    }

    private void checkStrikeAll(int strikes) {
        if (strikes == 3) {
            foundCorrectAnswer = true;
            checkFinishOrNot();
        }
    }

    private void checkFinishOrNot() {
        int newGame = scanner.nextInt();

        if (newGame == 2) {
            finishGame = true;
        }
    }

    public boolean isFinished() {
        return finishGame;
    }
}
