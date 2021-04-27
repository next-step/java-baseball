package baseball.domain;

import java.util.Objects;

public class Ball {

  private static final Integer MIN = 1;
  private static final Integer MAX = 9;
  private final Integer number;

  public Ball(Integer number) {
    validate(number);
    this.number = number;
  }

  private void validate(Integer number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("1이상 9이하 숫자를 입력해주세요.");
    }
  }

  public String getNumber() {
    return String.valueOf(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ball ball1 = (Ball) o;
    return Objects.equals(number, ball1.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
