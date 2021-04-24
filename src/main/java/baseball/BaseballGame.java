package baseball;

import baseball.domain.BaseBall;
import baseball.domain.RandomStrategy;

public class BaseballGame {

  public static void main(String[] args) {
    BaseBall baseball = BaseBall.createBaseball(new RandomStrategy());
    System.out.println(baseball);
  }

}
