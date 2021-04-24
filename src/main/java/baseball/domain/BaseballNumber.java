package baseball.domain;

import java.util.Objects;

public class BaseballNumber {

  public static final String NUMBER_RANGE_ERROR_MESSAGE = "number must be 0~9";

  private int number;

  public BaseballNumber(int number) {
    if (0 > number || number > 9) {
      throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseballNumber that = (BaseballNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return "BaseballNumber{" +
        "number=" + number +
        '}';
  }
}
