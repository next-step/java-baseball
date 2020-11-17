package study;

import java.util.*;

public class BaseballRandomValueGenerator {
  private final int SIZE = 3;

  private final int MAX_VALUE = 9;

  private List<Integer> numbers;

  public BaseballRandomValueGenerator() {
    this.generate();
  }

  private int peek() {
    Random random = new Random();
    return random.nextInt(MAX_VALUE) + 1;
  }

  private void generate() {
    Set<Integer> uniqueNumbers = new HashSet<>();
    while (uniqueNumbers.size() < this.SIZE) {
      uniqueNumbers.add(this.peek());
    }
    this.numbers = new ArrayList<>(uniqueNumbers);
  }

  public void shuffle() {
    List<Integer> copyNumbers = new ArrayList<>(this.numbers);
    do {
      Collections.shuffle(this.numbers);
    } while(copyNumbers.equals(this.numbers));
  }

  public int toInt() {
    int exponent = this.SIZE - 1;
    int sum = 0;
    for (final Integer number : this.numbers) {
      sum += number * (int) Math.pow(10, exponent);
      exponent--;
    }
    return sum;
  }

  public List<Integer> getValue() {
    return this.numbers;
  }
}