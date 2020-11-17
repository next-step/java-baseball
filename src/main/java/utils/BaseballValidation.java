package utils;

public class BaseballValidation {
  public static boolean validateInputNumber(String input) {
    int len = input.length();
    if (len > 3  || len < 3) {
      return false;
    }
    return true;
  }

  public static boolean isFourBall(int strike, int ball) { return isZero(strike + ball);}

  public static boolean isZero(int value) {
    return value == 0;
  }

  public static boolean isNothing(int index) {
    return index < 0;
  }

  public static int isBall(int i, int index) {
    return i != index ? 1 : 0;
  }

  public static int isStrike(int i, int index) {
    return i == index ? 1 : 0;
  }
}
