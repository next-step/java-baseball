package baseball.computer;

import baseball.common.MyBall;
import baseball.common.BaseBall;

import java.util.HashSet;

public class Computer {

  private MyBall myBall;

  public Computer() {
    this.myBall = new MyBall(new BaseBall());
  }

  public HashSet<Integer> getMyBall() {
    return myBall.getMyBaseballs();
  }

}
