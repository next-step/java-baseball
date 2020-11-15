package baseball.app;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.Set;

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

  public void recordScore(Score strikeOrBall) {
    if (Score.NONE.equals(strikeOrBall)) return;
    if (Score.STRIKE.equals(strikeOrBall)) {
      scoreMap.put(Score.STRIKE, scoreMap.get(Score.STRIKE) == null ? 1 : scoreMap.get(Score.STRIKE) + 1);
    }
    if (Score.BALL.equals(strikeOrBall)) {
      scoreMap.put(Score.BALL, scoreMap.get(Score.BALL) == null ? 1 : scoreMap.get(Score.BALL) + 1);
    }
  }

  public boolean isGameSuccess() {
    if (scoreMap.get(Score.STRIKE) == null) return false;
    return scoreMap.get(Score.STRIKE) == 3;
  }

  public String printScore() {
    StringBuilder sb = new StringBuilder();
    if(scoreMap.isEmpty()) return Score.NONE.getName();
    scoreMap.forEach( (score,number) -> {
      sb.append(number);
      sb.append(" ");
      sb.append(score.getName());
      sb.append(" ");
    });
    return sb.substring(0,sb.length()-1);
  }


}
