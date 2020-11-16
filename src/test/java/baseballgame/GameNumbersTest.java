package baseballgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseballgame.exceptions.ViolationException;

public class GameNumbersTest {
  @Test
  @DisplayName("Basic case")
  void basicCreationTest() {
    GameNumbers numbers = new GameNumbers(GameNumber.createArray(new int[] { 5, 1, 8 }));
    assertThat(numbers.get(0).getValue()).isEqualTo(5);
    assertThat(numbers.get(1).getValue()).isEqualTo(1);
    assertThat(numbers.get(2).getValue()).isEqualTo(8);
  }

  @Test
  @DisplayName("Compare test")
  void compareWithTest() {
    GameNumbers numbers = new GameNumbers(GameNumber.createArray(new int[] { 5, 1, 8 }));
    GameNumbers onlyS1 = new GameNumbers(GameNumber.createArray(new int[] { 6, 2, 8 }));
    GameNumbers onlyB2 = new GameNumbers(GameNumber.createArray(new int[] { 1, 5, 7 }));
    GameNumbers bothS1B1 = new GameNumbers(GameNumber.createArray(new int[] { 1, 6, 8 }));
    GameNumbers bothS1B2 = new GameNumbers(GameNumber.createArray(new int[] { 8, 1, 5 }));
    GameNumbers onlyS2 = new GameNumbers(GameNumber.createArray(new int[] { 2, 1, 8 }));
    GameNumbers onlyB3 = new GameNumbers(GameNumber.createArray(new int[] { 1, 8, 5 }));
    GameNumbers onlyS3 = new GameNumbers(GameNumber.createArray(new int[] { 5, 1, 8 }));
    GameNumbers nothing1 = new GameNumbers(GameNumber.createArray(new int[] { 2, 4, 9 }));
    GameNumbers nothing2 = new GameNumbers(GameNumber.createArray(new int[] { 6, 3, 7 }));

    assertThat(numbers.compareWith(onlyS1).strikes).isEqualTo(1);
    assertThat(numbers.compareWith(onlyS1).balls).isEqualTo(0);

    assertThat(numbers.compareWith(onlyB2).strikes).isEqualTo(0);
    assertThat(numbers.compareWith(onlyB2).balls).isEqualTo(2);

    assertThat(numbers.compareWith(bothS1B1).strikes).isEqualTo(1);
    assertThat(numbers.compareWith(bothS1B1).balls).isEqualTo(1);

    assertThat(numbers.compareWith(bothS1B2).strikes).isEqualTo(1);
    assertThat(numbers.compareWith(bothS1B2).balls).isEqualTo(2);

    assertThat(numbers.compareWith(onlyS2).strikes).isEqualTo(2);
    assertThat(numbers.compareWith(onlyS2).balls).isEqualTo(0);

    assertThat(numbers.compareWith(onlyB3).strikes).isEqualTo(0);
    assertThat(numbers.compareWith(onlyB3).balls).isEqualTo(3);

    assertThat(numbers.compareWith(onlyS3).strikes).isEqualTo(3);
    assertThat(numbers.compareWith(onlyS3).balls).isEqualTo(0);

    assertThat(numbers.compareWith(nothing1).strikes).isEqualTo(0);
    assertThat(numbers.compareWith(nothing1).balls).isEqualTo(0);

    assertThat(numbers.compareWith(nothing2).strikes).isEqualTo(0);
    assertThat(numbers.compareWith(nothing2).balls).isEqualTo(0);
  }

  @Test
  @DisplayName("Create with invalid length")
  void invalidLenCreationTest() {
    assertThatExceptionOfType(ViolationException.class).isThrownBy(() -> {
      new GameNumbers(GameNumber.createArray(new int[] { 1 }));
    }).withMessage("Numbers must have length " + GameNumbers.DIGITS + ".");
    assertThatExceptionOfType(ViolationException.class).isThrownBy(() -> {
      new GameNumbers(GameNumber.createArray(new int[] { 1, 2, 3, 4 }));
    }).withMessage("Numbers must have length " + GameNumbers.DIGITS + ".");
  }
}
