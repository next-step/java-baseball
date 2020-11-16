package baseball.domain;

import java.util.List;

public class Hint {

    private int ballCount = 0;
    private int strikeCount = 0;

    public Hint(Number number1, Number number2) {
        List<Integer> digits1 = number1.getDigits();
        List<Integer> digits2 = number2.getDigits();

        for (int i = 0; i < Game.BASEBALL_NUMBER_SIZE; i++) {
            count(digits1, digits2, i);
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isAllStrike() {
        return strikeCount == Game.BASEBALL_NUMBER_SIZE;
    }

    private void count(List<Integer> digits1, List<Integer> digits2, int index) {
        Integer digit1 = digits1.get(index);
        Integer digit2 = digits2.get(index);
        if (digit1.equals(digit2)) {
            strikeCount ++;
        } else if (digits1.contains(digit2)) {
            ballCount ++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append(" 스트라이크 ");
        }
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append(" 볼 ");
        }
        return stringBuilder.length() == 0 ? "낫싱" : stringBuilder.toString();
    }
}
