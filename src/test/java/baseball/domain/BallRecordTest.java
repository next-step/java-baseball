package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BallRecordTest {

  @Test
  @DisplayName("StrikeZone의 증가된 카운트를 반환한다.")
  void plusCount() {
    // given
    BallRecord ballRecord = BallRecord.create();

    // when
    BallRecord actual = ballRecord.plusCount(StrikeZone.STRIKE)
            .plusCount(StrikeZone.STRIKE)
            .plusCount(StrikeZone.BALL);

    // then
    Map<StrikeZone, Integer> expected = new HashMap<>();
    expected.put(StrikeZone.STRIKE, 2);
    expected.put(StrikeZone.BALL, 1);

    assertThat(actual)
            .hasFieldOrPropertyWithValue("value", expected);
  }
}