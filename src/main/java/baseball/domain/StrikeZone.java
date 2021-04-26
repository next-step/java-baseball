package baseball.domain;

public enum StrikeZone {
  STRIKE(true, true, "스트라이크"),
  BALL(true, false, "볼"),
  MISS;

  private final boolean existNumber;
  private final boolean sameDigit;
  private final String name;

  StrikeZone() {
    this(false, false, "폭투");
  }

  StrikeZone(boolean existNumber, boolean sameDigit, String name) {
    this.existNumber = existNumber;
    this.sameDigit = sameDigit;
    this.name = name;
  }

  public static StrikeZone valueOf(boolean existNumber, boolean sameDigit) {
    for (StrikeZone strikeZone : StrikeZone.values()) {
      if (strikeZone.equalsOf(existNumber, sameDigit)) {
        return strikeZone;
      }
    }

    return StrikeZone.MISS;
  }

  public String getName() {
    return name;
  }

  private boolean equalsOf(boolean existNumber, boolean sameDigit) {
    return this.existNumber == existNumber
            && this.sameDigit == sameDigit;
  }
}
