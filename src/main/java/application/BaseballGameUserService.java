package application;

import java.util.Scanner;
import utils.BaseballValidation;
import domain.BaseballCountVo;

public class BaseballGameUserService {

  private static Scanner scan = new Scanner(System.in);
  public int BASEBALL_LENGTH = 3;

  public boolean isGameStart() {
    System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요");
    String status = scan.nextLine();

    return "1".equals(status);
  }

  public String playerInputValue() {
    String input = "";
    while (!BaseballValidation.validateInputNumber(input)) {
      System.out.println("\n숫자를 입력해주세요 : ");
      input = scan.nextLine();
    }

    return input;
  }

  public boolean printBallStatus(BaseballCountVo result) {
    int strike = result.getStrike();
    int ball = result.getBall();

    if (BaseballValidation.isZero(strike) && BaseballValidation.isZero(ball)) {
      printNothing();
    }

    printStrikeCount(result.getStrike());
    printBallCount(result.getBall());

    return matchStrike(strike);
  }

  private boolean matchStrike(int strike) {
    if (strike == BASEBALL_LENGTH) {
      System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임종료");
      return true;
    }

    return false;
  }

  private void printNothing() {
    System.out.print("포볼!");
  }

  private void printBallCount(int count) {
    if (BaseballValidation.isZero(count)) {
      return;
    }

    System.out.print(count + " 볼");
  }

  private void printStrikeCount(int count) {
    if (BaseballValidation.isZero(count)) {
      return;
    }

    System.out.print(count + " 스트라이크");
  }
}
