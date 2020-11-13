package io.homo_efficio.base_ball;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class Result {

    private int balls;
    private int strikes;

    public Result(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public String getText() {
        String s = strikes > 0 ? strikes + " 스트라이크" : "";
        String b = balls > 0 ? balls + " 볼" : "";
        return (strikes == 0 && balls == 0) ? "낫싱" : (s + " " + b).trim();
    }

    public boolean is3Strikes() {
        return strikes == 3;
    }
}
