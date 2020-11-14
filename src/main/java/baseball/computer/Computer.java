package baseball.computer;

import baseball.game.CreateBall;

import java.util.LinkedHashSet;

public class Computer {

  private final LinkedHashSet<Integer> balls;

  public Computer() {
    this.balls = new CreateBall().createRandomBalls();
  }

  public LinkedHashSet<Integer> getBalls() {
    return this.balls;
  }

}
