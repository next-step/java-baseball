package baseball.domain;

import java.util.Objects;

public class Number {
  private static final String ERROR_NUMBER_ALLOWABLE_RANGE_OVER_FORMAT = "%d 는 허용된 숫자 범위(%d ~ %d)가 아닙니다.";
  private static final int MIN = 1;
  private static final int MAX = 9;

  private final int value;

  private Number(int value) {
    this.value = value;
  }

  public static Number create(int value) {
    checkAllowableRange(value);
    return new Number(value);
  }

  private static void checkAllowableRange(int value) {
    if (!( MIN <= value && value <= MAX )) {
      throw new IllegalArgumentException(String.format(ERROR_NUMBER_ALLOWABLE_RANGE_OVER_FORMAT, value, MIN, MAX));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Number number = (Number) o;
    return value == number.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Number{" +
            "value=" + value +
            '}';
  }
}
