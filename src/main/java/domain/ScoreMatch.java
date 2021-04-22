package domain;

import domain.enums.Score;

public class ScoreMatch {
    private String randomNumber;
    private int strikeCount;

    public ScoreMatch(Number randomNumber) {
        this.randomNumber = randomNumber.getNumber();
        this.strikeCount = 0;
    }

    public void clear() {
        strikeCount = 0;
    }

    public boolean compare(Number inputNumber) {
        String inputNum = inputNumber.getNumber();

        clear();
        countStrike(inputNum);

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

    public void print() {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            sb.append(strikeCount).append(Score.STRIKE.getTitle()).append(" ");
        }

        System.out.println(sb);
    }
}
