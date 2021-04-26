package validator;

import java.util.HashSet;
import java.util.Set;

public class NumberFormatValidator {

  public static void validate(String input) {
    checkParseToInteger(input);
    checkDifferentNumber(input);
    checkNumberLength(input);
  }

  public static boolean isValidate(int number) {
    return !hasSameNumber(number) && !hasZero(number);
  }

  private static boolean hasZero(int number) {
    return String.valueOf(number).contains("0");
  }

  private static boolean isParseInteger(String input) {
    for (char c : input.toCharArray()) {
      if (c <= '0' || c > '9') {
        return false;
      }
    }
    return true;
  }

  public static void checkParseToInteger(String input) {
    if (!isParseInteger(input)) {
      throw new IllegalArgumentException("입력은 숫자로만 구성되어야 합니다.");
    }
  }

  private static boolean hasSameNumber(int random) {
    Set<Integer> numbers = new HashSet<>();
    while (random > 0) {
      numbers.add(random % 10);
      random = random / 10;
    }
    return numbers.size() != 3;
  }

  private static void checkDifferentNumber(String input) {
    if (hasSameNumber(Integer.parseInt(input))) {
      throw new IllegalArgumentException("서로 다른 3자리 숫자로 구성되어야 합니다.");
    }
  }

  private static void checkNumberLength(String input) {
    if (input.length() != 3) {
      throw new IllegalArgumentException("3자리 숫자로 구성되어야 합니다.");
    }
  }

}
