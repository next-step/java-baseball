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
