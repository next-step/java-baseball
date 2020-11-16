package study;

import java.util.Arrays;
import java.util.List;

public class BaseballUtil {
  public static List<Integer> splitNumber(int number) {
    int temp;

    int firstNumber = number / 100;
    temp = number % 100;

    int secondNumber = temp / 10;
    temp = temp % 10;

    int thridNumber = temp;

    return Arrays.asList(firstNumber, secondNumber, thridNumber);
  }
}
