package baseball.view;

import java.util.Scanner;

public final class InputView {
  private static final Scanner SCANNER;
  private static final String WRITE_NUMBER_ANSWER = "숫자를 입력해주세요 : ";
  private static final String RESTART_GAME_ANSWER_FORMAT = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
  private static final int NUMBER_OF_RESTART = 1;
  private static final int NUMBER_OF_GAME_END = 2;

  static {
    SCANNER = new Scanner(System.in);
  }

  private InputView() {
  }

  public static String getNumberString() {
    System.out.print(WRITE_NUMBER_ANSWER);
    return SCANNER.next();
  }

  public static int getRestartOrEndGame() {
    System.out.println(String.format(RESTART_GAME_ANSWER_FORMAT, NUMBER_OF_RESTART, NUMBER_OF_GAME_END));
    int input = SCANNER.nextInt();
    if (!( isRestart(input) || isEndGame(input) )) {
      return getRestartOrEndGame();
    }
    return input;
  }

  public static boolean isRestart(int input) {
    return input == NUMBER_OF_RESTART;
  }

  private static boolean isEndGame(int input) {
    return input == NUMBER_OF_GAME_END;
  }
}
