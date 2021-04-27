package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Balls {
  private static final int BALL_SIZE = 3;
  private final Set<Ball> ballSet;

  public Balls(String balls) {
    validateInput(balls);
    ballSet = new HashSet<>();
    for (String number : balls.split("")) {
      ballSet.add(new Ball(Integer.parseInt(number)));
    }
    validateSize(ballSet.size(), "서로 다른 공이어야 합니다.");
  }

  public Balls(HashSet<Ball> ballsSet) {
    ballSet = ballsSet;
    validateSize(ballSet.size(), "서로 다른 공이어야 합니다.");
  }

  private void validateInput(String balls) {
    if (!balls.chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
    validateSize(balls.length(), "숫자 3개를 입력하셔야 합니다.");
  }

  private void validateSize(int size, String s) {
    if (size != BALL_SIZE) {
      throw new IllegalArgumentException(s);
    }
  }
}
