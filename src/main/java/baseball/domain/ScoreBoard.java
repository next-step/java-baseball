package baseball.domain;

import java.util.EnumMap;

public class ScoreBoard {

  private static final Integer THREE = 3;
  private static final String EMPTY = "";
  private static final String SPACE = " ";
  private final EnumMap<Score, Integer> scoreMap;

  public ScoreBoard() {
    scoreMap = new EnumMap<Score, Integer>(Score.class);
  }

  public ScoreBoard(EnumMap<Score, Integer> map) {
    scoreMap = map;
  }

  public void recordScore(Score score) {
    scoreMap.putIfAbsent(score, 0);
    scoreMap.computeIfPresent(score, (key, value) -> value + 1);
  }

  public EnumMap<Score, Integer> getScoreMap() {
    return scoreMap;
  }

  public String getScores() {
    StringBuilder builder = new StringBuilder();
    String nothing = checkNothing();
    if (!nothing.equals(EMPTY)) {
      return nothing;
    }
    builder.append(checkStrike());
    builder.append(SPACE);
    builder.append(checkBall());
    return builder.toString().trim();
  }

  private String checkNothing() {
    if (THREE.equals(scoreMap.get(Score.NOTHING))) {
      return Score.NOTHING.getDescription();
    }
    return EMPTY;
  }

  private String checkStrike() {
    if (scoreMap.containsKey(Score.STRIKE)) {
      return scoreMap.get(Score.STRIKE) + " " + Score.STRIKE.getDescription();
    }
    return EMPTY;
  }

  private String checkBall() {
    if (THREE.equals(scoreMap.get(Score.BALL))) {
      return Score.FOUR_BALL.getDescription();
    }
    if (scoreMap.containsKey(Score.BALL)) {
      return scoreMap.get(Score.BALL) + " " + Score.BALL.getDescription();
    }
    return EMPTY;
  }
}
