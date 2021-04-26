package baseball;

import java.util.Scanner;

public class BaseballGame {
    private Scanner scanner = new Scanner(System.in);
    private Baseball baseball = new Baseball();
    private String answerNumberString;
    private boolean finishGame = false;
    private boolean foundCorrectAnswer;

    public void startGame() {
        answerNumberString = baseball.makeAnswerNumber();

        foundCorrectAnswer = false;
        while (!foundCorrectAnswer) {
            Judgement judgement = judge(getInput());
            System.out.println(baseball.makeResultStringOf(judgement));
            finishIfAllStrike(judgement);
        }
    }

    private String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.toString(scanner.nextInt());
    }

    private Judgement judge(String input) {
        if (baseball.isValidInput(input)) {
            return new Judgement(countStrikes(input), countBalls(input));
        }
        return new Judgement(0, 0);
    }

    private int countStrikes(String input) {
        return baseball.countStrikes(answerNumberString, input);
    }

    private int countBalls(String input) {
        return baseball.countBalls(answerNumberString, input);
    }

    private void finishIfAllStrike(Judgement judgement) {
        if (judgement.strikeAll()) {
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
