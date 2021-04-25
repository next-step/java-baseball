package numberbaseball.domain;

import java.util.*;

public class CountScore {

  private static final Integer STRIKE_SCORE_CAN_GAME_OVER = 3;

  private final Map<Count, Integer> countAndScore;
  public CountScore(List<Count> countsOfExpectInning) {
    Map<Count, Integer> countCollected = new EnumMap<>(Count.class);
    for (Count countOfExpect : countsOfExpectInning) {
      calculateScore(countCollected, countOfExpect);
    }
    this.countAndScore = countCollected;
  }

  private void calculateScore(Map<Count, Integer> countScoreMap, Count countOfExpect) {
    if(countScoreMap.computeIfPresent(countOfExpect, (count, integer) -> ++integer) == null) {
      countScoreMap.put(countOfExpect, 1);
    }
  }

  public boolean isGameOverScore() {
    return STRIKE_SCORE_CAN_GAME_OVER.equals(countAndScore.get(Count.STRIKE));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CountScore that = (CountScore) o;
    return countAndScore.equals(that.countAndScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countAndScore);
  }
}
