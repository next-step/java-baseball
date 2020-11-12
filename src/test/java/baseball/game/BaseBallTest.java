package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallTest {

  private BaseBall baseBall;

  @BeforeEach
  void setUp() {
    baseBall = new BaseBall();
  }

  @DisplayName("숫자만 입력 가능 (정상)")
  @ParameterizedTest
  @ValueSource(strings = { "234", "654", "236"})
  void validate_input_number_type(final String inputNumber) {
    assertDoesNotThrow(() -> baseBall.validateInputNumberType(new Scanner(inputNumber)));
  }

  @DisplayName("숫자만 입력 가능 (실패)")
  @ParameterizedTest
  @ValueSource(strings = {"3f2", "2d3", "9fd"})
  void validate_input_number_type_bad_request(final String inputNumber) {
    InputMismatchException exception = assertThrows(
      InputMismatchException.class,
        () -> baseBall.validateInputNumberType(new Scanner((inputNumber)))
    );

    assertTrue(exception.getMessage().contains("숫자만 입력이 가능합니다."));
  }

  @DisplayName("3개의 숫 입력 여부 (정상)")
  @ParameterizedTest
  @ValueSource(ints = {235, 532, 194})
  void validate_input_number_size(final int inputNumber) {
    assertDoesNotThrow(() -> baseBall.validateInputNumberSize(inputNumber));
  }

  @DisplayName("3개의 숫 입력 여부 (실패)")
  @ParameterizedTest
  @ValueSource(ints = {2354, 5321, 1943})
  void validate_input_number_size_bad_request(final int inputNumber) {
    IllegalArgumentException exception = assertThrows(
      IllegalArgumentException.class,
        () -> baseBall.validateInputNumberSize(inputNumber)
    );

    assertTrue(exception.getMessage().contains("3개의 입력 숫자가 필요합니다."));
  }

  @DisplayName("중복 된 숫자가 포함되어 있는 경우 (정상)")
  @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}")
  @CsvSource({
    "1, 5, 9",
    "1, 8, 5"
  })
  void validate_input_number_to_ball_size(final int oneNumber,
                                          final int twoNumber,
                                          final int threeNumber) {
    assertDoesNotThrow(() -> baseBall.validateInputNumberToBallSize(
      new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)))
    );
  }

  @DisplayName("중복 된 숫자가 포함되어 있는 경우 (실패)")
  @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}")
  @CsvSource({
      "5, 5, 9",
      "5, 8, 5"
  })
  void validate_input_number_to_ball_size_bad_request(final int oneNumber,
                                                      final int twoNumber,
                                                      final int threeNumber) {
    IllegalArgumentException exception = assertThrows(
      IllegalArgumentException.class,
        () -> baseBall.validateInputNumberToBallSize(new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)))
    );

    assertTrue(exception.getMessage().contains("중복 된 숫자가 포함되어 있습니다."));
  }

  @DisplayName("사용자 입력 받은 숫자 LinkedHashSet 생성")
  @ParameterizedTest
  @ValueSource(ints = {235, 532, 194})
  void create_input_number_to_balls(final int inputNumber) {
    String[] splitNumber = String.valueOf(inputNumber).split("");
    LinkedHashSet<Integer> balls = baseBall.createInputNumberToBalls(inputNumber);

    int index = 0;

    for (Integer ball : balls) {
      assertEquals(ball, Integer.parseInt(splitNumber[index]));
      index++;
    }
  }

  @DisplayName("사용자 입력 받은 값과 컴퓨터 입력 한 숫자와 스트라이크 비교")
  @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}, " +
    "fourNumber={3}, fiveNumber={4}, sixNumber={5}"
  )
  @CsvSource({
    "1, 4, 9, 1, 4, 5",
    "1, 8, 5, 1, 8, 2",
  })
  void check_user_ball_and_computer_ball(final int oneNumber,
                                         final int twoNumber,
                                         final int threeNumber,
                                         final int fourNumber,
                                         final int fiveNumber,
                                         final int sixNumber) {
    baseBall.checkUserBallAndComputerBall(
      new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)),
      new LinkedHashSet<>(Arrays.asList(fourNumber, fiveNumber, sixNumber))
    );

    assertEquals(baseBall.getStrike(), 2);
  }

  @DisplayName("사용자 입력 받은 값과 컴퓨터 입력 한 숫자와 스트라이크 비교후 아닌 경우 볼 비교")
  @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}, " +
    "fourNumber={3}, fiveNumber={4}, sixNumber={5}"
  )
  @CsvSource({
      "2, 4, 9, 1, 2, 4",
      "5, 1, 8, 4, 5, 1",
  })
  void check_user_ball_and_computer_ball_no_strike_after_ball(final int oneNumber,
                                                              final int twoNumber,
                                                              final int threeNumber,
                                                              final int fourNumber,
                                                              final int fiveNumber,
                                                              final int sixNumber) {
    baseBall.checkUserBallAndComputerBall(
      new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)),
      new LinkedHashSet<>(Arrays.asList(fourNumber, fiveNumber, sixNumber))
    );

    assertEquals(baseBall.getStrike(), 0);
    assertEquals(baseBall.getBall(), 2);
  }

}