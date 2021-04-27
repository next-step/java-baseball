package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BallFactory {

  private static final Integer MIN = 1;
  private static final Integer MAX = 9;
  private static final List<Ball> CACHE_BALLS = new ArrayList<>();

  static {
    for (int i = MIN; i <= MAX; i++) {
      CACHE_BALLS.add(new Ball(i));
    }
  }

  public static Balls createBalls(String balls) {
    return new Balls(balls);
  }

  public static Balls createComputerBalls() {
    Collections.shuffle(CACHE_BALLS);
    HashSet<Ball> ballsSet = new HashSet<>(CACHE_BALLS.subList(0, 3));
    for (Ball ball : ballsSet) {
      System.out.printf(ball.getNumber());
    }
    return new Balls(ballsSet);
  }

}
