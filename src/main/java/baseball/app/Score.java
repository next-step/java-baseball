package baseball.app;

/**
 * @author choijaeyong on 2020/11/11.
 * @project java-baseball
 * @description
 */
public enum Score {
  STRIKE("스트라이크"),BALL("볼"),NONE("낫싱");

  private String name;
  Score(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
}
