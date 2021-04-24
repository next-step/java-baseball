package baseball.view;

public class ResultView {

  public static final String SUUCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String RESULT_FORMAT = "%d스트라이크 %d볼 %n";
  public static final String FOUR_BALL = "포볼";

  public static void print(int strikeCount, int ballCount) {
    System.out.println(getResultMessage(strikeCount, ballCount));
  }

  private static Object getResultMessage(int strikeCount, int ballCount) {
    if (strikeCount == 0 && ballCount == 0) {
      return FOUR_BALL;
    }
    return String.format(RESULT_FORMAT, strikeCount, ballCount);
  }

  public static void printEnd() {
    System.out.println(SUUCESS_MESSAGE);
  }
}
