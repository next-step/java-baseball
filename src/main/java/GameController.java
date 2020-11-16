import baseballgame.BaseballGame;
import baseballgame.Result;
import baseballgame.exceptions.InputException;
import ui.InputInterface;
import ui.OutputInterface;

public class GameController {
  static BaseballGame baseballGame = new BaseballGame();
  static InputInterface in = new InputInterface(System.in);
  static OutputInterface out = new OutputInterface(System.out);
  private static final String startingMessage = "게임을 시작합니다.";
  private static final String inputMessage = "숫자를 입력해주세요 : ";
  private static final String winningMessage = BaseballGame.DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료.";
  private static final String continueMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  private static final String invalidChoiceMessage = "잘못 입력하셨습니다. 1, 2 중 하나를 입력하세요.";

  public static void main(String args[]) {
    boolean cont = true;
    while (cont) {
      out.println(startingMessage);
      runGame();
      out.println(continueMessage);
      cont = checkContinue();
    }
    return;
  }

  public static int[] strToIntArray(String s) {
    int[] arr = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      arr[i] = s.charAt(i) - '0';
    }
    return arr;
  }

  public static boolean checkContinue() {
    while (true) {
      String input = in.getInput();
      if ("1".equals(input)) {
        return true;
      }
      if ("2".equals(input)) {
        return false;
      }
      out.println(invalidChoiceMessage);
      out.println(continueMessage);
    }
  }

  public static void runGame() {
    baseballGame.init();
    while (true) {
      out.print(inputMessage);
      int[] userInput = strToIntArray(in.getInput());
      try {
        baseballGame.validateInput(userInput);
      } catch (InputException e) {
        out.println(e.getMessage());
        continue;
      } catch (Exception e) {
        e.printStackTrace();
        System.exit(-1);
      }

      Result result = baseballGame.matchWithAnswer(userInput);
      out.println(result.getMessage());
      if (result.hasWin()) {
        out.println(winningMessage);
        break;
      }
    }
  }
}
