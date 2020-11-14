package application;

import java.util.Scanner;
import utils.BaseballValidation;
import domain.BaseballCountVo;

public class BaseballGameUserService {
  private static Scanner scan = new Scanner(System.in);

  public String playerInputValue() {
    String input = "";
    while (!BaseballValidation.validateInputNumber(input)) {
      System.out.println("\n숫자를 입력해주세요 : ");
      input = scan.nextLine();
    }

    return input;
  }
}
