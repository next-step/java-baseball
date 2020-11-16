package baseballgame;

import baseballgame.exceptions.ViolationException;

public class GameNumber {
  private static final int MAX_VALUE = 9;
  private static final int MIN_VALUE = 1;

  private int value;

  public static GameNumber[] createArray(int[] intArray) {
    GameNumber[] numbers = new GameNumber[intArray.length];
    for (int i = 0; i < intArray.length; i++) {
      numbers[i] = new GameNumber(intArray[i]);
    }
    return numbers;
  }

  public GameNumber(int value) {
    if (value > MAX_VALUE || value < MIN_VALUE) {
      throw new ViolationException("Value must be in the range 1~9.");
    }
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
