package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HintCounter {
  private final int NOTHING_COUNT = 0;
  private final int INCREASE_COUNT_UNIT = 1;
  private final Map<Hint, Integer> counterMap = new HashMap<>();
  private int size = 0;

  private HintCounter(Baseball userBaseball, Baseball gameBaseball) {
    for (Hint hint : createHints(userBaseball, gameBaseball)) {
      countHint(hint);
    }
  }

  private List<Hint> createHints(Baseball userBaseball, Baseball gameBaseball) {
    List<Hint> hints = new ArrayList<>();
    BaseballNumbers userBaseballNumbers = userBaseball.getBaseballNumbers();
    BaseballNumbers gameBaseballNumbers = gameBaseball.getBaseballNumbers();

    for (int i = 0; i < userBaseballNumbers.size(); i++) {
      BaseballNumber userBaseballNumber = userBaseballNumbers.getBaseballNumbers().get(i);
      hints.add(Hint.create(gameBaseballNumbers.isContains(userBaseballNumber), gameBaseballNumbers.isExpectedPosition(userBaseballNumber, i)));
    }

    return hints;
  }

  private void countHint(Hint hint) {
    increaseSize();
    if (isCountedHint(hint)) {
      counterMap.put(hint, counterMap.get(hint) + INCREASE_COUNT_UNIT);
      return;
    }

    counterMap.put(hint, INCREASE_COUNT_UNIT);
  }

  private void increaseSize() {
    size++;
  }

  private boolean isCountedHint(Hint hint) {
    return counterMap.containsKey(hint);
  }

  public int getCount(Hint hint) {
    if (isCountedHint(hint)) {
      return counterMap.get(hint);
    }

    return NOTHING_COUNT;
  }

  public boolean isAllStrike() {
    return getCount(Hint.STRIKE) == size;
  }

  public boolean isAllNothing() {
    return getCount(Hint.NOTHING) == size;
  }

  public static HintCounter of(Baseball userBaseball, Baseball gameBaseball) {
    return new HintCounter(userBaseball, gameBaseball);
  }
}
