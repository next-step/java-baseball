package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

  @DisplayName("3 스트라이크 출력 테스트")
  @Test
  void three_strike() {
    EnumMap<Score,Integer> map = new EnumMap<Score, Integer>(Score.class);
    map.put(Score.STRIKE,3);
    ScoreBoard scoreBoard = new ScoreBoard(map);
    assertThat(scoreBoard.getScores()).isEqualTo("3 스트라이크");
  }

  @DisplayName("포볼 출력 테스트")
  @Test
  void three_ball() {
    EnumMap<Score,Integer> map = new EnumMap<Score, Integer>(Score.class);
    map.put(Score.BALL,3);
    ScoreBoard scoreBoard = new ScoreBoard(map);
    assertThat(scoreBoard.getScores()).isEqualTo("포볼");
  }

  @DisplayName("낫싱 출력 테스트")
  @Test
  void nothing() {
    EnumMap<Score,Integer> map = new EnumMap<Score, Integer>(Score.class);
    map.put(Score.NOTHING,3);
    ScoreBoard scoreBoard = new ScoreBoard(map);
    assertThat(scoreBoard.getScores()).isEqualTo("낫싱");
  }

  @DisplayName("1스트라이크 2볼 출력 테스트")
  @Test
  void one_strike_two_ball() {
    EnumMap<Score,Integer> map = new EnumMap<Score, Integer>(Score.class);
    map.put(Score.STRIKE,1);
    map.put(Score.BALL,2);
    ScoreBoard scoreBoard = new ScoreBoard(map);
    assertThat(scoreBoard.getScores()).isEqualTo("1 스트라이크 2 볼");
  }

}