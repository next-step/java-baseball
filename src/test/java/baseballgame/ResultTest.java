package baseballgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
  @Test
  @DisplayName("Message test")
  void resultTest() {
    Result result = new Result(1, 1);
    assertThat(result.getMessage()).isEqualTo("1스트라이크 1볼");
    assertThat(result.hasWin()).isEqualTo(false);

    result.strikes = 0;
    assertThat(result.getMessage()).isEqualTo("1볼");
    assertThat(result.hasWin()).isEqualTo(false);

    result.strikes = 2;
    result.balls = 0;
    assertThat(result.getMessage()).isEqualTo("2스트라이크");
    assertThat(result.hasWin()).isEqualTo(false);

    result.strikes = 0;
    result.balls = 0;
    assertThat(result.getMessage()).isEqualTo("낫싱");
    assertThat(result.hasWin()).isEqualTo(false);

    result.strikes = 3;
    result.balls = 0;
    assertThat(result.getMessage()).isEqualTo("3스트라이크");
    assertThat(result.hasWin()).isEqualTo(true);
  }
}
