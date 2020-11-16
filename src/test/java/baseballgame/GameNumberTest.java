package baseballgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseballgame.exceptions.ViolationException;

public class GameNumberTest {
  @DisplayName("Basic case")
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
  void basicTest(int value) {
    GameNumber number = new GameNumber(value);
    assertThat(number.getValue()).isEqualTo(value);
  }

  @DisplayName("Out of range exception")
  @ParameterizedTest
  @ValueSource(ints = { -10, -1, 0, 10, 15, 20, 100 })
  void outOfRangeTest(int value) {
    assertThatExceptionOfType(ViolationException.class).isThrownBy(() -> {
      new GameNumber(value);
    }).withMessage("Value must be in the range 1~9.");
  }

  @Test
  @DisplayName("Create array test")
  void createArrayTest() {
    GameNumber[] array = GameNumber.createArray(new int[] { 1, 2, 3 });
    assertThat(array[0].getValue()).isEqualTo(1);
    assertThat(array[1].getValue()).isEqualTo(2);
    assertThat(array[2].getValue()).isEqualTo(3);
  }
}
