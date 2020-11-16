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
    String expectedMessage = "Input must have length with " + BaseballGame.DIGITS + ".";

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 2, 3, 4 });
    }).withMessage(expectedMessage);

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] {});
    }).withMessage(expectedMessage);
  }

  @Test
  @DisplayName("input validation - out of range")
  void validateOutOfRangeInputTest() {
    BaseballGame game = new BaseballGame();

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 0, 1, 4 });
    }).withMessage("Number 0 is out of range.");

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 10, 4 });
    }).withMessage("Number 10 is out of range.");
  }

  @Test
  @DisplayName("input validation - duplication")
  void validateDuplicateInputTest() {
    BaseballGame game = new BaseballGame();

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 1, 1 });
    }).withMessage("No duplication allowed for input.");

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 1, 4, 4 });
    }).withMessage("No duplication allowed for input.");

    assertThatExceptionOfType(InputException.class).isThrownBy(() -> {
      game.validateInput(new int[] { 6, 6, 3 });
    }).withMessage("No duplication allowed for input.");
  }

  @Test
  @DisplayName("Match with answer")
  void matchWithAnswerTest() {
    BaseballGame game = new BaseballGame();
    game.init(() -> {
      return new int[] { 7, 2, 3 };
    });

    Result result = game.matchWithAnswer(new int[] { 2, 1, 4 });
    assertThat(result).isEqualToComparingFieldByField(new Result(0, 1));

    result = game.matchWithAnswer(new int[] { 2, 7, 3 });
    assertThat(result).isEqualToComparingFieldByField(new Result(1, 2));

    result = game.matchWithAnswer(new int[] { 4, 5, 9 });
    assertThat(result).isEqualToComparingFieldByField(new Result(0, 0));

    result = game.matchWithAnswer(new int[] { 7, 2, 3 });
    assertThat(result).isEqualToComparingFieldByField(new Result(3, 0));
  }
}
