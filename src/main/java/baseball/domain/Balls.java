package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Balls {
  private static final int BALL_SIZE = 3;
  private final List<Ball> ballList;

  public Balls(String balls) {
    validateInput(balls);
    Set<Ball> ballSet = new LinkedHashSet<>();
    for (String number : balls.split("")) {
      ballSet.add(new Ball(Integer.parseInt(number)));
    }
    validateSize(ballSet.size(), "서로 다른 공이어야 합니다.");
    ballList = new ArrayList<>(ballSet);
  }

  public Balls(HashSet<Ball> ballsSet) {
    validateSize(ballsSet.size(), "서로 다른 공이어야 합니다.");
    ballList = new ArrayList<>(ballsSet);
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

  public int size() {
    return ballList.size();
  }

  public Score calculateScore(Balls userBalls, int index) {
    Ball computerBall = ballList.get(index);
    if (computerBall.equals(userBalls.ballList.get(index))) {
      return Score.STRIKE;
    }
    if (ballList.contains(userBalls.ballList.get(index))) {
      return Score.BALL;
    }
    return Score.NOTHING;
  }
}
