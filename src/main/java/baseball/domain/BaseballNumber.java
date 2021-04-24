package baseball.domain;

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
}
