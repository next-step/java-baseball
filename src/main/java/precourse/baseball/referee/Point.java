package precourse.baseball.referee;

public abstract class Point {

  private int cnt;

  public void init() {
    this.cnt = 0;
  }

  public void increment() {
    this.cnt++;
  }

  public boolean atLeastOnce() {
    return this.cnt != 0;
  }

  public boolean threeTimes() {
    return cnt == 3;
  }

  public int getCnt() {
    return cnt;
  }
}
