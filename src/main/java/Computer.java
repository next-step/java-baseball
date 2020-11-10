import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

  private Set<Integer> nums;
  private int number;

  public Computer() {
    this.nums = new LinkedHashSet<>();
  }

  public int newNumber() {
    makeThreeNumber();
    numsToString();
    return number;
  }

  private void makeThreeNumber() {
    while (nums.size() < 3) {
      int element = (int) (Math.random() * 9) + 1;
      nums.add(element);
    }
  }

  private void numsToString() {
    StringBuilder sb = new StringBuilder();
    for (int n : nums) {
      sb.append(n);
    }
    number = Integer.parseInt(sb.toString());
  }

  public int getHundredNumber() {
    return number / 100;
  }

  public int getTenNumber() {
    return number / 10 % 10;
  }

  public int getOneNumber() {
    return number % 100 % 10;
  }
}
