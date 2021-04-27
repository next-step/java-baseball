package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    Map<StrikeZone, Integer> expected = new EnumMap<>(StrikeZone.class);
    expected.put(StrikeZone.STRIKE, 2);
    expected.put(StrikeZone.BALL, 1);

    assertThat(actual)
            .hasFieldOrPropertyWithValue("values", expected);
  }

  @Test
  @DisplayName("3 스트라이크인지 판단하는 메서드 추가")
  void isStrikeOut() {
    // given
    BallRecord ballRecord = BallRecord.create()
            .plusCount(StrikeZone.STRIKE)
            .plusCount(StrikeZone.STRIKE)
            .plusCount(StrikeZone.STRIKE);

    // when
    boolean isStrikeOut = ballRecord.isStrikeOut();

    // then
    assertThat(isStrikeOut).isTrue();
  }

  @Test
  @DisplayName("특정 key를 제외하여 keySet을 반환한다.")
  void keySetFromIgnoreKeys() {
    // given
    BallRecord ballRecord = BallRecord.create()
            .plusCount(StrikeZone.STRIKE)
            .plusCount(StrikeZone.BALL)
            .plusCount(StrikeZone.MISS);

    // when

    // then
    assertAll(
            () -> assertThat(ballRecord.keySetFromIgnoreKeys())
                    .containsExactly(StrikeZone.STRIKE, StrikeZone.BALL, StrikeZone.MISS),
            () -> assertThat(ballRecord.keySetFromIgnoreKeys(StrikeZone.STRIKE))
                    .containsExactly(StrikeZone.BALL, StrikeZone.MISS),
            () -> assertThat(ballRecord.keySetFromIgnoreKeys(StrikeZone.BALL))
                    .containsExactly(StrikeZone.STRIKE, StrikeZone.MISS),
            () -> assertThat(ballRecord.keySetFromIgnoreKeys(StrikeZone.BALL, StrikeZone.MISS))
                    .containsExactly(StrikeZone.STRIKE),
            () -> assertThat(ballRecord.keySetFromIgnoreKeys(StrikeZone.STRIKE, StrikeZone.BALL, StrikeZone.MISS))
                    .isEmpty()
            );
  }
}