package baseball.game;

import baseball.common.Print;
import baseball.computer.Computer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class BaseBall {

  private final static int BALL_SIZE = 3;

  private final static int INDEX_OF_RESULT = -1;

  private final Computer computer;

  private final Scanner scanner;

  private int strike;

  private int ball;

  public BaseBall() {
    this.computer = new Computer();
    this.scanner = new Scanner(System.in);
    this.strike = 0;
    this.ball = 0;
  }

  int getStrike() {
    return this.strike;
  }

  int getBall() {
    return this.ball;
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

    checkUserBallAndComputerBall(balls, getComputerBalls());
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

  /**
   * 사용자 입력 받은 숫자와 컴퓨터 숫자의 비교 메소드
   * @param computerBalls 컴퓨터 숫자 LinkedHashSet
   * @param userBalls 사용자 숫자 LinkedHashSet
   */
  void checkUserBallAndComputerBall(final LinkedHashSet<Integer> computerBalls,
                                    final LinkedHashSet<Integer> userBalls) {
    List<Integer> converterUserBalls = new ArrayList<>(userBalls);
    List<Integer> converterComputerBalls = new ArrayList<>(computerBalls);

    for (int i = 0; i < BALL_SIZE; i++) {
      checkStrike(converterUserBalls.get(i), converterComputerBalls.get(i), converterComputerBalls);
    }
  }

  /**
   * 스트라이크 체크
   * @param userBall 사용자 가지고 있는 ball
   * @param computerBall 컴퓨터 가지고 있는 ball
   * @param computerBalls 컴퓨터 숫자 LinkedHashSet
   */
  private void checkStrike(final Integer userBall,
                           final Integer computerBall,
                           final List<Integer> computerBalls) {
    boolean isStrike = false;

    if (userBall.equals(computerBall)) {
      this.strike++;
      isStrike = true;
    }

    if (!isStrike) {
      checkBall(userBall, computerBalls);
    }

  }

  /**
   * 스트라이크가 아닌 경우 볼 체크 하기
   * @param userBall 사용자 가지고 있는 ball
   * @param computerBalls 컴퓨터 숫자 LinkedHashSet
   */
  private void checkBall(final Integer userBall,
                         final List<Integer> computerBalls) {

    if (computerBalls.indexOf(userBall) != INDEX_OF_RESULT) {
      this.ball++;
    }
  }

}
