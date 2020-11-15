package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballInputNumber {

  private final List<Integer> numberList;

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 9;
  private static final String OVER_INPUT_LENGTH = "3자리의 숫자를 입력해주세요.";
  private static final String OVER_ONE_TO_NINE_NUMBER = "1에서 9사이의 숫자로 입력해주세요.";
  private static final String DUPLICATED_NUMBER = "모두 다른 수로 입력해주세요.";

  public BaseballInputNumber(String numbers) {
    numberList = new ArrayList<>();
    char[] inputs = numbers.toCharArray();
    for (char c : inputs) {
      int number = Integer.parseInt(String.valueOf(c));
      validateNumber(number);
      numberList.add(number);
    }
    validateNumbers();
  }

  private void validateNumbers() {
    if (numberList.size() != 3) {
      throw new IllegalArgumentException(OVER_INPUT_LENGTH);
    }

    Set<Integer> dupRemovedSet = new HashSet<>(numberList);
    if (dupRemovedSet.size() != numberList.size()) {
      throw new IllegalArgumentException(DUPLICATED_NUMBER);
    }
  }
  
  private void validateNumber(Integer number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(OVER_ONE_TO_NINE_NUMBER);
    }
  }

  public List<Integer> getNumberList() {
    return this.numberList;
  }

}
