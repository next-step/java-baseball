package precourse.baseball.pitcher;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PitcherTest {

  @Test
  void givenPitcherWithRandom_whenGetNumbers_thenDifferentThreeNumbers() {
    // Given
    Pitcher pitcher = new Pitcher(new Random());

    // When
    Set<Integer> pitch = pitcher.pitch();

    // Then
    assertEquals(3, pitch.size());
  }

  @Test
  public void givenPitcherWithRandom_whenGetNumbers_thenEachNumberRangeIsFromOneToNine() {
    // Given
    Pitcher pitcher = new Pitcher(new Random());

    // When
    Set<Integer> pitch = pitcher.pitch();

    // Then
    for (Integer number : pitch) {
      assertTrue(number >= 1 && number <= 9);
    }
  }
}