package baseball.game;

class Result {

  private final static int CLEAR_STRIKE_COUNT = 3;

  private int strike;

  private int ball;

  Result() {
    this.strike = 0;
    this.ball = 0;
  }

  int getStrike() {
    return strike;
  }

  int getBall() {
    return ball;
  }

  void addStrike() {
    this.strike++;
  }

  void addBall() {
    this.ball++;
  }

  boolean isNoting() {
    return this.strike == 0 && this.ball == 0;
  }

  boolean isStrike() {
    return this.strike == CLEAR_STRIKE_COUNT;
  }

}
