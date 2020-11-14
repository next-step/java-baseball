package baseball.app;

import java.util.EnumMap;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class ScoreTable {
  private final EnumMap<Score,Integer> scoreMap;

  public ScoreTable() {
    scoreMap = new EnumMap<>(Score.class);
  }

  public EnumMap<Score,Integer> getScoreMap() {
    return scoreMap;
  }

  public void record(Score score) {
    if (Score.STRIKE.equals(score)) {
      scoreMap.put(Score.STRIKE, scoreMap.get(Score.STRIKE) == null ? 1 : scoreMap.get(Score.STRIKE) + 1);
      return;
    }

  }
}
