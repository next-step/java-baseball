package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BaseballGameTest {

  @Test
  @DisplayName("야구게임 검증")
  void testReferee() throws Exception {
    BaseballGame baseballGame = new BaseballGame();
    baseballGame.referee(Arrays.asList(5, 6, 7));
    System.out.println(baseballGame.getMessage());
  }
}
