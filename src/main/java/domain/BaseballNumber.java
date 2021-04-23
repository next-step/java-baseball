package domain;

import java.util.HashMap;
import java.util.Map;

public class BaseballNumber {
  static final int MINIMUM_BALL_NUMBER = 1;
  static final int MAXIMUM_BALL_NUMBER = 9;
  private static final Map<Integer, BaseballNumber> CACHE = new HashMap<>();

  static {
    for (int i = MINIMUM_BALL_NUMBER; i <= MAXIMUM_BALL_NUMBER; i++) {
      CACHE.put(i, new BaseballNumber(i));
    }
  }

  private int ballNumber;

  private BaseballNumber(int ballNumber) {
    this.ballNumber = ballNumber;
  }

  public int getBallNumber() {
    return ballNumber;
  }


  private static void validate(int number) {
    if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
      throw new IllegalArgumentException(String
          .format("야구공 번호 범위를 벗어날 수 없습니다. 허용 범위(%d ~ %d)", MINIMUM_BALL_NUMBER,
              MAXIMUM_BALL_NUMBER));
    }
  }

  public static BaseballNumber from(int number) {
    validate(number);
    return CACHE.get(number);
  }
}
