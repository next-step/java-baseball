package baseball.domain;

public enum StrikeZone {
  STRIKE(true, true),
  BALL(true, false),
  MISS;

  private final boolean existNumber;
  private final boolean sameDigit;

  StrikeZone() {
    this(false, false);
  }

  StrikeZone(boolean existNumber, boolean sameDigit) {
    this.existNumber = existNumber;
    this.sameDigit = sameDigit;
  }

  public static StrikeZone valueOf(boolean existNumber, boolean sameDigit) {
    for (StrikeZone strikeZone : StrikeZone.values()) {
      if (strikeZone.equalsOf(existNumber, sameDigit)) {
        return strikeZone;
      }
    }

    return StrikeZone.MISS;
  }

  private boolean equalsOf(boolean existNumber, boolean sameDigit) {
    return this.existNumber == existNumber
            && this.sameDigit == sameDigit;
  }
}
