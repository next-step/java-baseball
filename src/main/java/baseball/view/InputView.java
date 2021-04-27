package baseball.view;

import baseball.domain.BallFactory;
import baseball.domain.Balls;
import java.util.Scanner;

public class InputView {

  private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
  private static final Scanner SCANNER = new Scanner(System.in);

  public static Balls inputNumbers() {
    System.out.println(INPUT_NUMBER);
    return BallFactory.createBalls(SCANNER.next());
  }
}
