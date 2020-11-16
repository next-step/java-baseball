package baseball;

public class Result {
  private int strike = 0;
  private int ball = 0;

  public Result(int strike, int ball) {
    this.strike = strike;
    this.ball = ball;
  }

  public boolean isAnswer() {
    if (strike == 3) {
      System.out.println(ResultType.GAME_OVER);
      return true;
    }
    return false;
  }

  public void printResult() {
    if (strike == 0 && ball == 0) {
      System.out.print(ResultType.NOTHING);
    }
    if (strike != 0) {
      System.out.print(String.format(ResultType.STRIKE, strike));
    }
    if (ball != 0) {
      System.out.print(String.format(ResultType.BALL, ball));
    }
    System.out.println();
  }
}
