package view;

import java.util.Scanner;

public class InputView {
  private static final Scanner INPUT = new Scanner(System.in);
  private static final String BASEBALL_INPUT_COMMENT = "숫자를 입력해주세요";

  public static String inputBaseball() {
    System.out.println(BASEBALL_INPUT_COMMENT + ":");
    return INPUT.next();
  }
}
