package baseballgame;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseballgame.exceptions.InputException;

public class BaseballGameTest {
  @Test
  @DisplayName("input validation - basic case")
  void validateNormalInputTest() {
    BaseballGame game = new BaseballGame();
    assertThatCode(() -> {
      game.validateInput(new int[] { 3, 9, 4 });
    }).doesNotThrowAnyException();
  }

  @Test
  @DisplayName("input validation - input length")
  void validateInputLengthTest() {
    BaseballGame game = new BaseballGame();
    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 2, 3, 4 });
    }).withMessage("Input must have length with " + BaseballGame.DIGITS + ".");
    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] {});
    }).withMessage("Input must have length with " + BaseballGame.DIGITS + ".");
  }

  @Test
  @DisplayName("input validation - out of range")
  void validateOutOfRangeInputTest() {
    BaseballGame game = new BaseballGame();
    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 0, 1, 4 });
    }).withMessage("Number 0 is out of range.");
  }

  @Test
  @DisplayName("input validation - duplication")
  void validateDuplicateInputTest() {
    BaseballGame game = new BaseballGame();
    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 1, 1 });
    }).withMessage("No duplication allowed for input.");
  }
}
