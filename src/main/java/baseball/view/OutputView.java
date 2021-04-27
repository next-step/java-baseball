package baseball.view;

public class OutputView {

    private int strike = 0;
    private int ball = 0;

    public OutputView(int strike, int ball) {
        this.ball = ball;
        this.strike = strike;
    }

    public void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
        System.out.println(strike + " 스트라이크, " + ball + "볼");
    }

}
