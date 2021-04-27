package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

  @DisplayName("스트라이크 3 테스트")
  @Test
  void strike_test() {
    Referee referee = new Referee(new Balls("123"), new Balls("123"));
    ScoreBoard scoreBoard = referee.judge();
    EnumMap<Score, Integer> map = scoreBoard.getScoreMap();
    assertThat(map.containsKey(Score.STRIKE)).isTrue();
    assertThat(map.containsKey(Score.BALL)).isFalse();
    assertThat(map.get(Score.STRIKE)).isEqualTo(3);
  }

  @DisplayName("볼3 테스트")
  @Test
  void ball_test() {
    Referee referee = new Referee(new Balls("123"), new Balls("312"));
    ScoreBoard scoreBoard = referee.judge();
    EnumMap<Score, Integer> map = scoreBoard.getScoreMap();
    assertThat(map.containsKey(Score.BALL)).isTrue();
    assertThat(map.containsKey(Score.STRIKE)).isFalse();
    assertThat(map.get(Score.BALL)).isEqualTo(3);
  }

  @DisplayName("스트라이크1 볼2 테스트")
  @Test
  void strike_one_ball_two_test() {
    Referee referee = new Referee(new Balls("123"), new Balls("132"));
    ScoreBoard scoreBoard = referee.judge();
    EnumMap<Score, Integer> map = scoreBoard.getScoreMap();
    assertThat(map.get(Score.STRIKE)).isEqualTo(1);
    assertThat(map.get(Score.BALL)).isEqualTo(2);
  }

  @DisplayName("스트라이크1 볼1 테스트")
  @Test
  void strike_one_ball_one_test() {
    Referee referee = new Referee(new Balls("123"), new Balls("134"));
    ScoreBoard scoreBoard = referee.judge();
    EnumMap<Score, Integer> map = scoreBoard.getScoreMap();
    assertThat(map.get(Score.STRIKE)).isEqualTo(1);
    assertThat(map.get(Score.BALL)).isEqualTo(1);
  }

  @DisplayName("낫싱 테스트")
  @Test
  void four_ball_test() {
    Referee referee = new Referee(new Balls("123"), new Balls("456"));
    ScoreBoard scoreBoard = referee.judge();
    EnumMap<Score, Integer> map = scoreBoard.getScoreMap();
    assertThat(map.containsKey(Score.NOTHING)).isTrue();
  }

}