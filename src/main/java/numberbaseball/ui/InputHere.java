package numberbaseball.ui;

import numberbaseball.dto.ExpectNumbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHere {

  private static final String PLEASE_INPUT_NUMBERS = "숫자를 입력주세요 : ";
  private static final String INPUT_SHOULD_INTEGER = "자연수로 입력 해 주세요.";
  private static final Scanner SCANNER = new Scanner(System.in);

  private InputHere() {}

  public static ExpectNumbers getExpectNumbers() {
    System.out.println(PLEASE_INPUT_NUMBERS);
    return new ExpectNumbers(getIntValue());

  }

  private static int getIntValue() {
    try {
      return SCANNER.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(INPUT_SHOULD_INTEGER, e);
    } finally {
      SCANNER.nextLine();
    }
  }


}
