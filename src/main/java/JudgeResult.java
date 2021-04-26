import java.util.List;

public class JudgeResult {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void judgeEach(List<Integer> questions, int index, int answer) {
        if (questions.get(index).equals(answer)) {
            this.strike++;
            return;
        }
        if (questions.contains(answer)) {
            this.ball++;
        }
    }

    public boolean isSolved() {
        return this.strike == 3;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
