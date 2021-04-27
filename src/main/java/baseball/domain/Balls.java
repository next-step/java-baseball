package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {
  private static final int BALL_SIZE = 3;
  private Set<Ball> ballSet;

  private static final Integer MIN = 1;
  private static final Integer MAX = 9;

  private static final List<Ball> CACHE_BALLS = new ArrayList<>();

  static {
    for (int i=MIN; i <= MAX ; i++) {
      CACHE_BALLS.add(new Ball(i));
    }
  }

  public Balls() {
    Collections.shuffle(CACHE_BALLS);
    ballSet = new HashSet<>(CACHE_BALLS.subList(0, 3));
    validateSize(ballSet.size(), "서로 다른 공이어야 합니다.");
  }

  public Balls(String balls) {
    validateInput(balls);
    ballSet = Arrays.stream(balls.split(""))
        .map(ball -> CACHE_BALLS.get(Integer.parseInt(ball)))
        .collect(Collectors.toSet());
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
