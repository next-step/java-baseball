package baseballgame;

import java.util.HashSet;
import java.util.Set;

import baseballgame.exceptions.*;

public class BaseballGame {
  public static final int DIGITS = 3;

  public void validateInput(int[] input) throws InputException {
    checkLength(input);
    for (int i : input) {
      checkOutOfRange(i);
    }
    checkDuplication(input);
  }

  private void checkLength(int[] input) throws InputException {
    if (input.length != DIGITS) {
      throw new InputException("Input must have length with " + DIGITS + ".");
    }
  }

  private void checkOutOfRange(int i) throws InputException {
    if (i > 9 || i < 1) {
      throw new InputException("Number " + i + " is out of range.");
    }
  }

  private void checkDuplication(int[] input) throws InputException {
    Set<Integer> tempSet = new HashSet<>();
    for (int i : input) {
      tempSet.add(i);
    }
    if (tempSet.size() != DIGITS) {
      throw new InputException("No duplication allowed for input.");
    }
    }
  }
}
