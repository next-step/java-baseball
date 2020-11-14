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

  public void strikeRecord(Integer score) {
    scoreMap.putIfAbsent(Score.STRIKE, score);
  }

  public void ballRecord(int score) {
    scoreMap.putIfAbsent(Score.BALL, score);
  }

  public void recordScore(Score strikeOrBall) {
    if (Score.STRIKE.equals(strikeOrBall)) {
      scoreMap.put(Score.STRIKE, scoreMap.get(Score.STRIKE) == null ? 1 : scoreMap.get(Score.STRIKE) + 1);
    }

    if (Score.BALL.equals(strikeOrBall)) {
      scoreMap.put(Score.BALL, scoreMap.get(Score.BALL) == null ? 1 : scoreMap.get(Score.BALL) + 1);
    }


  }
}
