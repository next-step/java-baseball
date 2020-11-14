package baseball.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import baseball.common.PrintMessage;
import baseball.common.Print;
import baseball.computer.Computer;

public class BaseBall {

  private final static String STRIKE = "스트라이크";

  private final static String BALL = "볼";

  private final static String NOTHING = "낫싱";

  private final static int BALL_SIZE = 3;

  private final static int INDEX_OF_RESULT = -1;

  private final static int CLEAR_STRIKE_COUNT = 3;

  private final static int GAME_RETRY = 1;

  private Scanner scanner;

  private Computer computer;

  private Result result;

  public BaseBall() {
    this.scanner = new Scanner(System.in);
    this.computer = new Computer();
    this.result = new Result();
  }

  Result getResult() {
    return this.result;
  }

  private void createComputer() {
    this.computer = new Computer();
  }

  private LinkedHashSet<Integer> getComputerBalls() {
    return this.computer.getBalls();
  }

  /**
   * 숫자 야구 게임 시작
   */
  public void play() {
    this.result = new Result();

    getPrintByMessage(PrintMessage.INPUT_NUMBER_MESSAGE);

    validateGameRule();

    writeMatchMessage();

    if(!checkBallResult()) {
      this.play();
    }
  }

  /**
   * 게임 진행 시 필요한 전체적인 Rule 체크 메소드
   */
  private void validateGameRule() {
    try {
      int inputNumber = validateInputNumberType(this.scanner);

      validateInputNumberSize(inputNumber);

      LinkedHashSet<Integer> balls = createInputNumberToBalls(inputNumber);

      checkUserBallAndComputerBall(getComputerBalls(), balls);
    } catch (IllegalArgumentException | InputMismatchException e) {
      validateGameRuleFail(e.getMessage());
    }
  }

  /**
   * 게임 진행 시 필요한 전체적인 Rule 체크 실패 시 Error Message 호출
   * @param errorMessage Error Message
   */
  private void validateGameRuleFail(final String errorMessage) {
    getPrintByMessage(errorMessage);
    this.scanner = new Scanner(System.in);
    this.play();
  }

  /**
   * 사용자 입력 받은 값 타입 체크
   * @return 사용자 입력 받은 값 return
   */
  int validateInputNumberType(final Scanner scanner) {
    int inputNumber;

    try {
      inputNumber = scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new InputMismatchException(PrintMessage.INPUT_NUMBER_ERROR);
    }

    return inputNumber;
  }

  /**
   * 사용자 입력 받은 숫자 3개 여부 체크
   * @param inputNumber 사용자 입력 숫자
   */
  void validateInputNumberSize(final int inputNumber) {
    if (String.valueOf(inputNumber).length() != BALL_SIZE) {
      throw new IllegalArgumentException(PrintMessage.INPUT_NUMBER_SIZE_ERROR);
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
      throw new IllegalArgumentException(PrintMessage.INPUT_NUMBER_DUPLICATE_ERROR);
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
      this.result.addStrike();
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
      this.result.addBall();
    }
  }

  /**
   * 사용자가 입력합 값 기반으로 결과값 체크
   */
  boolean checkBallResult() {
    boolean isClear = false;

    if (this.getResult().getStrike() == CLEAR_STRIKE_COUNT) {
      isClear = true;
    }

    return isClear;
  }

  /**
   * 스트라이크 & 볼 비교 후 메시지 출력
   */
  private void writeMatchMessage() {
    boolean isStrike = this.getResult().isClearStrike();

    if (isStrike) {
      checkResetGame();
    }

    if (!isStrike) {
      writeMatchFailMessage();
    }
  }

  /**
   * 게임을 클리어하지 않은 경우 메시지 출력
   */
  private void writeMatchFailMessage() {
    if (this.getResult().getStrike() == 0 && this.getResult().getBall() != 0) {
      getPrintByMessage(this.getResult().getBall() + BALL);
    }

    if (this.getResult().getStrike() != 0 && this.getResult().getBall() == 0) {
      getPrintByMessage(this.getResult().getStrike() + STRIKE);
    }

    if (this.getResult().getStrike() != 0 && this.getResult().getBall() != 0) {
      getPrintByMessage(this.getResult().getStrike() + STRIKE + " " + this.getResult().getBall() + BALL);
    }

    if (this.getResult().isNoting()) {
      getPrintByMessage(NOTHING);
    }
  }

  /**
   * 공통 메시지 노출 또는 결과 값 바인딩 메소드
   * @param message 메시지
   */
  private void getPrintByMessage(final String message) {
    Print.setPrintMessage(message);
  }

  /**
   * 게임 클리어스 재시작 여부 체크
   */
  private void checkResetGame() {
    getPrintByMessage(PrintMessage.BASE_BALL_GAME_CLEAR_MESSAGE);

    int inputNumber = validateInputNumberType(this.scanner);

    if (inputNumber != GAME_RETRY) {
      System.exit(0);
    }

    createComputer(); // 대결을 위한 새로운 컴퓨터 생성
    this.play();
  }

}
