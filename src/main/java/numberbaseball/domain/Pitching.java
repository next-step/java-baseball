package numberbaseball.domain;

import java.util.Objects;

public class Pitching {

  public static final int MIN = 1;
  public static final int MAX = 9;

  private static final String INVALID_ARGUMENT_MESSAGE = "%d 부터 %d 사이의 값을 입력해주세요.";

  private final int number;

  public Pitching(int number) {
    validateNumberRange(number);
    this.number = number;
  }

  private void validateNumberRange(int number) {
    if(isLessThanMin(number) || isGreaterThanMax(number)) {
      throw new IllegalArgumentException(String.format(INVALID_ARGUMENT_MESSAGE, MIN, MAX));
    }
  }

  private boolean isLessThanMin(int number) {
    return number < MIN;
  }
  private boolean isGreaterThanMax(int number) {
    return number > MAX;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pitching number1 = (Pitching) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
