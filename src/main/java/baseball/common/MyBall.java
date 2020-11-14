package baseball.common;

import java.util.HashSet;

public class MyBall {

  private HashSet<Integer> baseballs;

  public MyBall(BaseBall baseBall) {
    this.baseballs = baseBall.getBaseBalls();
  }

  public MyBall(HashSet<Integer> baseballs) {
    this.baseballs = baseballs;
  }

  public HashSet<Integer> getMyBaseballs() {
    return this.baseballs;
  }

}
