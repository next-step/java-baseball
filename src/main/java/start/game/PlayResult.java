package start.game;

import java.util.OptionalDouble;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if( status.isStrike() ) {
            strike++;
        }
        
        if( status.isBall() ) {
            ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == 3;
    }

}
