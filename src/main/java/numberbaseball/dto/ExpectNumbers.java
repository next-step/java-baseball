package numberbaseball.dto;

import numberbaseball.domain.Inning;
import numberbaseball.domain.Pitching;

import java.util.*;

public class ExpectNumbers {

  private static final int NUMBER_DIGITS_PER_EXPECTING = 3;
  private static final int DECIMAL_UNIT = 10;
  private static final int DIGIT_MINUS_THIS_IS_EXPONENT = 1;
  private static final int FIRST_VALUE_PER_DIGIT = 1;
  private static final int ZERO = 0;
  private static final String PLEASE_INPUT_THREE_DIGITS_INTEGER = "세자리 수를 입력해주세요.";
  private static final String PLEASE_INPUT_DIFFERENT_NUMBER_OF_DIGITS_EACH_OTHER = "각 자리수가 서로 다르게 입력해주세요.";

  private final Set<Integer> expect;
  public ExpectNumbers(int input) {
    if(getNumberOfDigits(input) != NUMBER_DIGITS_PER_EXPECTING) {
      throw new IllegalArgumentException(PLEASE_INPUT_THREE_DIGITS_INTEGER);
    }
    this.expect = collectByDigits(input);
  }

  public Inning transFormToInning() {
    List<Pitching> expectPitchings = transFormToPitchingList(expect);
    return new Inning(expectPitchings);
  }

  private List<Pitching> transFormToPitchingList(Set<Integer> integers) {
    List<Pitching> returnList = new ArrayList<>();
    for (Integer integer : integers) {
      Pitching pitching = new Pitching(integer);
      returnList.add(pitching);
    }
    return returnList;
  }

  private int getNumberOfDigits(int number) {
    int length = ZERO;
    int digit = FIRST_VALUE_PER_DIGIT;
    while (number / digit > ZERO) {
      length++;
      digit *= DECIMAL_UNIT;
    }
    return length;
  }

  private Set<Integer> collectByDigits(int number) {
    Set<Integer> result = new LinkedHashSet<>();
    int dividend = number;
    for(int exponent = NUMBER_DIGITS_PER_EXPECTING - DIGIT_MINUS_THIS_IS_EXPONENT; exponent >= ZERO; exponent--) {
      int digit = (int) Math.pow(DECIMAL_UNIT, exponent);
      int digitValue = dividend / digit;
      throwExceptionIfAddingFail(result, digitValue);
      dividend = dividend % digit;
    }
    return result;
  }

  private void throwExceptionIfAddingFail(Set<Integer> expect, int value) {
    if(!expect.add(value)) {
      throw new IllegalArgumentException(PLEASE_INPUT_DIFFERENT_NUMBER_OF_DIGITS_EACH_OTHER);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExpectNumbers that = (ExpectNumbers) o;
    return expect.equals(that.expect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expect);
  }
}
