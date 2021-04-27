package dev.cobi.domains;

/**
 * @author cobiyu
 */
public enum ResultType {
  STRIKE("스트라이크 "),
  BALL("볼"),
  NOTHING("낫싱");

  private final String name;

  /**
   * constructor
   * @param name 결과별 이름
   */
  ResultType(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}
