package baseballgame;

import java.util.HashMap;
import java.util.Map;

import baseballgame.exceptions.ViolationException;

public class GameNumbers {
  public static final int DIGITS = 3;
  private GameNumber[] numberArray;
  private Map<Integer, Integer> numberMap;

  public GameNumbers() {
    numberMap = new HashMap<>();
  }

  public GameNumbers(GameNumber[] gNumbers) {
    checkLength(gNumbers);
    numberMap = new HashMap<>();
    for (int i = 0; i < DIGITS; i++) {
      numberMap.put(gNumbers[i].getValue(), i);
    }
    checkMapSize(numberMap);
    this.numberArray = gNumbers;
  }

  public GameNumber get(int index) {
    return numberArray[index];
  }

  private void checkLength(GameNumber[] gNumbers) {
    if (gNumbers.length != DIGITS) {
      throw new ViolationException("Numbers must have length " + DIGITS + ".");
    }
  }

  private void checkMapSize(Map<Integer, Integer> map) {
    if (map.size() != DIGITS) {
      throw new ViolationException("No duplication allowed.");
    }
  }

  public Result compareWith(GameNumbers others) {
    Result result = new Result();
    for (int i = 0; i < DIGITS; i++) {
      result.strikes += isStrike(i, others.get(i));
    }
    for (int i = 0; i < DIGITS; i++) {
      result.balls += isBall(i, others.get(i));
    }
    return result;
  }

  private int isStrike(int pos, GameNumber other) {
    Integer myPos = numberMap.get(other.getValue());
    if (myPos != null && myPos == pos) {
      return 1;
    }
    return 0;
  }

  private int isBall(int pos, GameNumber other) {
    Integer myPos = numberMap.get(other.getValue());
    if (myPos != null && myPos != pos) {
      return 1;
    }
    return 0;
  }
}
