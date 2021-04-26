package numberbaseball.domain;

import java.util.*;

public class CountScore {

  private static final Integer SCORE_PER_INNING = 3;
  private static final Integer SCORE_COUNT_STARTING_VALUE = 1;

  private final Map<Count, Integer> countAndScore;
  public CountScore(List<Count> countsOfExpectInning) {
    this.countAndScore = groupBy(countsOfExpectInning);
  }

  private Map<Count, Integer> groupBy(List<Count> countsOfExpectInning) {
    Map<Count, Integer> countCollected = new EnumMap<>(Count.class);
    for (Count countOfExpect : countsOfExpectInning) {
      calculateScore(countCollected, countOfExpect);
    }
    return countCollected;
  }

  private void calculateScore(Map<Count, Integer> countScoreMap, Count countOfExpect) {
    Integer nonNullScoreOnlyKeyExist = countScoreMap.computeIfPresent(countOfExpect, (count, integer) -> ++integer);
    if(nonNullScoreOnlyKeyExist == null) {
      countScoreMap.put(countOfExpect, SCORE_COUNT_STARTING_VALUE);
    }
  }

  public boolean isGameOverScore() {
    return SCORE_PER_INNING.equals(countAndScore.get(Count.STRIKE));
  }

  public Map<Count, Integer> getCountAndScore() {
    return countAndScore;
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
