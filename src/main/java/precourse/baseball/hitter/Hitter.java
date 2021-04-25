package precourse.baseball.hitter;

import java.util.Scanner;

public class Hitter {

  public int[] hit() {
    int input = getInputNumber();

    int[] expect = new int[3];
    for (int i = 2; i >= 0; i--) {
      expect[i] = input % 10;
      input = input / 10;
    }

    return expect;
  }

  private int getInputNumber() {
    int input = new Scanner(System.in).nextInt();
    if ((int) (Math.log10(input) + 1) != 3) {
      throw new RuntimeException("Input three numbers !");
    }

    return input;
  }
}
