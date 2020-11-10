package woowahan.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBallTest {

  private BaseBall baseBall;

  @BeforeEach
  void setBaseBall() {
    baseBall = new BaseBall();
  }

  @Test
  void testGetRandomText_length() {
    // given
    // when
    String[] getRandomText = baseBall.getRandomText();
    // then
    assertEquals(getRandomText.length, 3);
  }

  @Test
  void testGetRandomText_naturalNumber() {
    // given
    // when
    String[] getRandomText = baseBall.getRandomText();
    // then
    assertTrue(isNumber(getRandomText));
  }

  @Test
  void testGetRandomText_duplication() {
    // given
    // when
    String[] getRandomText = baseBall.getRandomText();
    // then
    assertFalse(isDuplication(getRandomText));
  }

  @Test
  void testIsStrike() {
    // given
    String inputData = "-1";
    int idx = 0;
    // when
    int strike = baseBall.isStrike(inputData, idx);
    // then
    assertEquals(strike, 0);
  }

  @Test
  void testIsBall() {
    // given
    String inputData = "-1";
    int idx = 0;
    // when
    int ball = baseBall.isBall(inputData, idx);
    // then
    assertEquals(ball, 0);
  }

  @Test
  void testWriteMessage_낫싱() {
    // given
    int strike = 0;
    int ball = 0;
    // when
    String message = baseBall.writeMessage(strike, ball);
    // then
    assertEquals(message, "낫싱");
  }

  @Test
  void testWriteMessage_2스트라이크1볼() {
    // given
    int strike = 2;
    int ball = 1;
    // when
    String message = baseBall.writeMessage(strike, ball);
    // then
    assertEquals(message, "2 스트라이크 1 볼");
  }

  @Test
  void testResetGame() {
    // given
    String selected = "2";
    // when
    //baseBall.resetGame(selected);
  }

  private boolean isNumber(String[] s) {
    try {
      for(String value : s) {
        Double.parseDouble(value);
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean isDuplication(String[] s) {
    for (int i=0; i<s.length; i++) {
      String valueF = s[i];
      for (int j=0; j<s.length; j++) {
        if (i == j) continue;
        String valueT = s[j];
        if (valueF.equals(valueT)) {
          return true;
        }
      }
    }
    return false;
  }

}
