package io.homo_efficio.base_ball;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class Result {

    private final int balls;
    private final int strikes;
    private final int len;

    public Result(int balls, int strikes, int len) {
        this.balls = balls;
        this.strikes = strikes;
        this.len = len;
    }

    public String getText() {
        String s = strikes > 0 ? strikes + " 스트라이크" : "";
        String b = balls > 0 ? balls + " 볼" : "";
        return (strikes == 0 && balls == 0) ? "낫싱" : (s + " " + b).trim();
    }

    public boolean isAllStrikes() {
        return strikes == len;
    }
}
