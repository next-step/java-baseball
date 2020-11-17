package util;

public class GameUtils {

    public void endGame() {
        System.exit(0);
    }

    public void printHintMessage(int strike, int ball) {
        String hint = "";

        if(ball == 0)
            hint = strike + " 스트라이크";
        if(strike == 0)
            hint = ball + " 볼";
        if(strike > 0 && ball > 0)
            hint = strike + " 스트라이크 " + ball + " 볼";
        if(checkNothing(strike, ball))
            hint = "낫싱";

        System.out.println(hint);
    }

    public boolean checkNothing(int strike, int ball) {
        return (strike == 0 && ball == 0);
    }
}
