package study.baseball.service;

import study.baseball.enums.GameStatus;

import java.util.List;

public class ResultChecker {
    public static GameStatus gameStatus = GameStatus.PLAY;

    private List<Integer> userNumbers;
    private List<Integer> answerNumbers;

    private int strikeCount;
    private int ballCount;

    public ResultChecker() {
        this.answerNumbers = NumberGenerator.generateNumber();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void calculateResult() {
        for (int targetIndex=0; targetIndex<answerNumbers.size(); targetIndex++) {
            countMatchTypes(targetIndex);
        }
    }

    private void countMatchTypes(int targetIndex) {
        if (userNumbers.get(targetIndex) == answerNumbers.get(targetIndex)) {
            this.strikeCount++;
        } else if (answerNumbers.contains(userNumbers.get(targetIndex))) {
            this.ballCount++;
        }
    }

    public void notifyMatchResult(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
        this.calculateResult();

        System.out.print(this.strikeCount + "스트라이크 ");
        System.out.println(this.ballCount + "볼");
    }

    public void checkAllMatches() {
        if (this.strikeCount == 3) {
            gameStatus = GameStatus.END;
            gameStatus.printMessage();

            String flag = InputSupplier.getInput();
            checkPlayOrStop(flag);
        } else {
            this.resetGameCount();
        }
    }

    private void checkPlayOrStop(String flag) {
        if (GameStatus.PLAY.getCode().equals(flag)) {
            List<Integer> generateNumbers = NumberGenerator.generateNumber();

            this.resetGameCount();
            this.setAnswerNumbers(generateNumbers);

            gameStatus = GameStatus.PLAY;
        } else if (GameStatus.EXIT.getCode().equals(flag)){
            gameStatus = GameStatus.EXIT;
        }
    }

    public void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void resetGameCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
