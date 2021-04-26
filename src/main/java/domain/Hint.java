package domain;

public enum Hint {
  STRIKE, BALL, NOTHING;

  public static Hint create(boolean isContainsNumber, boolean isExpectedPosition) {
    if(isContainsNumber && isExpectedPosition) {
      return Hint.STRIKE;
    }

    if(isContainsNumber) {
      return Hint.BALL;
    }

    return Hint.NOTHING;
  }
}
