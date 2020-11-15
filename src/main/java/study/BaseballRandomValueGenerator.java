package study;

import java.util.*;

public class BaseballRandomValueGenerator {
  private final int SIZE = 3;

  private final int MAX_VALUE = 9;

  private List<Integer> numbers;

  public BaseballRandomValueGenerator() {
    Set<Integer> uniqueNumbers = new HashSet<>();
    while (uniqueNumbers.size() < this.SIZE) {
      uniqueNumbers.add(this.peekNumber());
    }
    numbers = new ArrayList<>(uniqueNumbers);
  }

  private int peekNumber() {
    Random random = new Random();
    return random.nextInt(MAX_VALUE) + 1;
  }

  public int getValue() {
    return toInt();
  }

  private int toInt() {
    int exponent = this.SIZE - 1;
    int sum = 0;
    for (final Integer number : this.numbers) {
      sum += number * (int) Math.pow(10, exponent);
      exponent--;
    }
    return sum;
  }

  public long containsSize(final int value) {
    return this.numbers.stream().filter(number -> number == value).count();
  }

  public int firstValue() {
    return this.numbers.get(0);
  }

  public int secondValue() {
    return this.numbers.get(1);
  }

  public int thirdValue() {
    return this.numbers.get(2);
  }
}