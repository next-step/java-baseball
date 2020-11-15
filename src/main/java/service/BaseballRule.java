package service;

public enum BaseballRule {
  STRIKE("스트라이크"),
  BALL("볼"),
  NOTHING("낫씽");

  private final String ruleName;

  BaseballRule(String ruleName) {
    this.ruleName = ruleName;
  }

  public static String getPrintRuleName(int strike, int ball) {
    StringBuilder builder = new StringBuilder();
    if (strike == 0 && ball == 0) {
      builder.append(NOTHING.ruleName);
    }
    if (strike > 0) {
      builder.append(strike).append(" ").append(STRIKE.ruleName).append(" ");
    }
    if (ball > 0) {
      builder.append(ball).append(" ").append(BALL.ruleName);
    }
    return builder.toString();
  }
}
