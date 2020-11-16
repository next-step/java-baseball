package baseball;

import java.util.Scanner;

public class BaseballGame {

  public void run() {
    boolean isPlay = true;
    while (isPlay) {
      game();
      isPlay = isReplay();
    }
  }

  public void game() {
    boolean isAnswer = false;
    Checker checker = new Checker(Computer.generateAnswer());
    while (!isAnswer) {
      int[] guessNumber = User.guess();
      Result result = checker.getScore(guessNumber);
      result.printResult();
      isAnswer = result.isAnswer();
    }
  }

  public boolean isReplay() {
    Scanner scan = new Scanner(System.in);
    boolean isValid = false;
    String replay = "";
    while (!isValid) {
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      replay = scan.nextLine();
      isValid = validateUserInput(replay);
    }
    return replay.equals("1");
  }

  public boolean validateUserInput(String input) {
    if (input.equals("1") || input.equals("2")) {
      return true;
    }
    System.out.println("1이나 2를 입력하세요!");
    return false;
  }
}
