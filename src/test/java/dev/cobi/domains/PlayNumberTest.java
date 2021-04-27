package dev.cobi.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author cobiyu
 */
class PlayNumberTest {

  @Test
  @DisplayName("중복된 숫자를 사용할 수 없다.")
  public void PreventDuplicateNumber(){
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("112"));
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("322"));
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("777"));
  }

  @Test
  @DisplayName("0으로 시작되는 숫자를 사용할 수 없다.")
  public void PreventZeroBeginNumber(){
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("012"));
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("000"));
    assertThrows(IllegalArgumentException.class, () -> new PlayNumber("001"));
  }
}
