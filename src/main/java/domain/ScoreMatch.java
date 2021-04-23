package domain;

import domain.enums.Score;

public class ScoreMatch {
    private String randomNumber;
    private int strikeCount;
    private int ballCount;

    public ScoreMatch(Number randomNumber) {
        this.randomNumber = randomNumber.getNumber();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void clear() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean compare(Number inputNumber) {
        clear();
        countStrike(inputNumber.getNumber());
        countBall(inputNumber.getNumber());

        return strikeCount == 3;
    }

    private void countStrike(String inputNum) {
        for (int i = 0; i < 3; i++) {
            addStrike(randomNumber.charAt(i), inputNum.charAt(i));
        }
    }

    private void addStrike(char target, char input) {
        if (target == input) {
            strikeCount++;
        }
    }

    private void countBall(String inputNum) {
        for (int i = 0; i < 3; i++) {
            addBall(inputNum.charAt(i), i);
        }
    }

    private void addBall(char input, int inputIndex) {
        int containIndex = randomNumber.indexOf(input);

        if ((containIndex != -1) && (containIndex != inputIndex)) {
            ballCount++;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            sb.append(strikeCount).append(Score.STRIKE.getTitle()).append(" ");
        }
        if (ballCount > 0) {
            sb.append(ballCount).append(Score.BALL.getTitle());
        }

        System.out.println(sb);
    }
}
