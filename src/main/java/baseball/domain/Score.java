package baseball.domain;

public enum Score {
  STRIKE("스트라이크"),
  BALL("볼"),
  NOTHING("낫싱"),
  FOUR_BALL("포볼");

  private String description;

  Score(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
