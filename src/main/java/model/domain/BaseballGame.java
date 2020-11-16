package model.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class BaseballGame {
    private Balls balls;
    private boolean end;

    public BaseballGame(List<Ball> balls) {
        this.balls = new Balls(balls);
        this.end = false;
    }

    public Record play(Balls playerBalls) {
        if (balls.equals(playerBalls)) {
            this.end = true;
            return Record.createWin();
        }

        int strikeCount = balls.equalsCount(playerBalls);
        int ballCount = balls.containCount(playerBalls) - strikeCount;

        return Record.of(strikeCount, ballCount);
    }
}
