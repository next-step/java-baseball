package baseballgame.ball;

import java.util.LinkedHashSet;

public interface BallsFactory {
    LinkedHashSet<Ball> createBalls();
}
