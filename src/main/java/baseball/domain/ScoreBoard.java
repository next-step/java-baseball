package baseball.domain;

import java.util.EnumMap;

public class ScoreBoard {
  private final EnumMap<Score,Integer> scoreMap;

  public ScoreBoard() {
    scoreMap = new EnumMap<Score, Integer>(Score.class);
  }

  public void recordScore(Score score) {
    scoreMap.putIfAbsent(score,0);
    scoreMap.computeIfPresent(score, (key,value) -> value + 1);
  }

  public EnumMap<Score,Integer> getScoreMap() {
    return scoreMap;
  }
}
