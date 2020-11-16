package baseballgame;

public class Result {
  private static final String STRIKE_STR = "스트라이크";
  private static final String BALL_STR = "볼";
  private static final String NOTHING_STR = "낫싱";
  private static final String SPACE_STR = " ";

  public int strikes;
  public int balls;

  public Result() {
    this(0, 0);
  }

  public Result(int s, int b) {
    this.strikes = s;
    this.balls = b;
  }

  public boolean hasWin() {
    return strikes == GameNumbers.DIGITS;
  }

  public String getMessage() {
    StringBuilder sb = new StringBuilder();
    if (strikes == 0 && balls == 0) {
      return new String(NOTHING_STR);
    }
    sb.append(strikes > 0 ? strikes + STRIKE_STR + SPACE_STR : "");
    sb.append(balls > 0 ? balls + BALL_STR : "");
    return sb.toString().trim();
  }
}
