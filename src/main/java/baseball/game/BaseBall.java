package baseball.game;

import baseball.common.Print;
import baseball.computer.Computer;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BaseBall {

  private final static int BALL_SIZE = 3;

  private final Computer computer;

  private final Scanner scanner;

  public BaseBall() {
    this.computer = new Computer();
    this.scanner = new Scanner(System.in);
  }

  private LinkedHashSet<Integer> getComputerBalls() {
    return this.computer.getBalls();
  }

  /**
   * 숫자 야구 게임 시작
   */
  public void play() {
    Print.setPrintMessage("숫자를 입력해주세요.");

    int inputNumber = validateInputNumberType(scanner);

    validateInputNumberSize(inputNumber);

    LinkedHashSet<Integer> balls = createInputNumberToBalls(inputNumber);
  }

  /**
   * 사용자 입력 받은 값 타입 체크
   * @param scanner 입력 받은 UI 객체
   * @return 사용자 입력 받은 값 return
   */
  int validateInputNumberType(final Scanner scanner) {
    int inputNumber;

    try {
      inputNumber = scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new InputMismatchException("숫자만 입력이 가능합니다.");
    }

    return inputNumber;
  }

  /**
   * 사용자 입력 받은 숫자 3개 여부 체크
   * @param inputNumber 사용자 입력 숫자
   */
  void validateInputNumberSize(final int inputNumber) {
    if (String.valueOf(inputNumber).length() != BALL_SIZE) {
      throw new IllegalArgumentException("3개의 입력 숫자가 필요합니다.");
    }
  }

  /**
   * 사용자 입력 받은 숫자 LinkedHashSet 생성
   * @param inputNumber 사용자 입력 숫자
   * @return 사용자 입력 받은 숫자 LinkedHashSet 생성 return
   */
  LinkedHashSet<Integer> createInputNumberToBalls(final int inputNumber) {
    String[] splitNumber = String.valueOf(inputNumber).split("");

    LinkedHashSet<Integer> balls = new LinkedHashSet<>();

    for (String ball : splitNumber) {
      balls.add(Integer.parseInt(ball));
    }

    validateInputNumberToBallSize(balls);

    return balls;
  }

  /**
   * 사용자 입력 중복 여부 체크
   * @param balls 사용자 입력 받은 숫자 LinkedHashSet
   */
  void validateInputNumberToBallSize(final LinkedHashSet<Integer> balls) {
    if (balls.size() != BALL_SIZE) {
      throw new IllegalArgumentException("중복 된 숫자가 포함되어 있습니다.");
    }
  }

}
