package domain;

public class BaseballCountVo {
  private int strike = 0;
  private int ball = 0;

  public BaseballCountVo() { }

  public BaseballCountVo(int strike, int ball) {
    this.strike = strike;
    this.ball = ball;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  @Override
  public String toString() {
    return "BaseballCountVo{" +
        "strike=" + strike +
        ", ball=" + ball +
        '}';
  }
}
