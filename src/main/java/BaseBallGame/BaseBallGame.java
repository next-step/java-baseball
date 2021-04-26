package BaseBallGame;

import java.util.Scanner;

public class BaseBallGame {

  int[] computerNumber = new int[3];

  public void main() {
    int[] inputNumberArray = new int[3];
    generateRandomNumber(computerNumber);
    boolean gameContinue = true;
    while (gameContinue) {
      setInputNumberToArray(inputNumberArray);
      int[] returnArray = compareToArrayNumber(computerNumber, inputNumberArray);
      printDescribeEachCase(returnArray);
      gameContinue = successSetNumberGame(gameContinue, returnArray[0]);
      gameContinue = chooseGameContinueOrOver(gameContinue);
    }
  }

  public boolean successSetNumberGame(boolean gameContinue, int i) {
    if (i == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n");
      gameContinue = false;
    }
    return gameContinue;
  }

  public boolean chooseGameContinueOrOver(boolean gameContinue) {
    if (gameContinue == false) {
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
      String newStartOrFinish = scanningInputNumber();
      gameContinue = divideToChoose1Or2(gameContinue, newStartOrFinish);
    }
    return gameContinue;
  }

  public boolean divideToChoose1Or2(boolean gameContinue, String newStartOrFinish) {
    if (newStartOrFinish.equals("1")) {
      gameContinue = isGameContinue();
    }
    if (newStartOrFinish.equals("2")) {
      gameContinue = false;
    }
    return gameContinue;
  }

  public boolean isGameContinue() {
    boolean gameContinue;
    computerNumber = new int[3];
    generateRandomNumber(computerNumber);
    gameContinue = true;
    return gameContinue;
  }

  public void printDescribeEachCase(int[] returnArray) {
    printStrikeAndBall(returnArray);
    printStrike(returnArray);
    printBall(returnArray);
    printNothing(returnArray);
  }

  public void printNothing(int[] returnArray) {
    if (returnArray[0] == 0 && returnArray[1] == 0) {
      System.out.println("낫싱");
    }
  }

  public void printBall(int[] returnArray) {
    if (returnArray[0] == 0 && returnArray[1] != 0) {
      System.out.printf("%d볼 \n", returnArray[1]);
    }
  }

  public void printStrike(int[] returnArray) {
    if (returnArray[0] != 0 && returnArray[1] == 0) {
      System.out.printf("%d 스트라이크 \n", returnArray[0]);
    }
  }

  public void printStrikeAndBall(int[] returnArray) {
    if (returnArray[0] != 0 && returnArray[1] != 0) {
      System.out.printf("%d 스트라이크 %d볼 \n", returnArray[0], returnArray[1]);
    }
  }

  public int[] compareToArrayNumber(int[] computerNumber, int[] inputNumberArray) {
    int[] returnArray = new int[2];

    int length = computerNumber.length;
    checkStrikeCount(computerNumber, inputNumberArray, returnArray, length);
    checkBallCount(computerNumber, inputNumberArray, returnArray, length);

    return returnArray;
  }

  public void checkBallCount(int[] computerNumber, int[] inputNumberArray,
      int[] returnArray, int length) {
    for (int i = 0; i < length; i++) {
      checkBallCountDoubleForConstruction(computerNumber, inputNumberArray, returnArray, length, i);
    }
  }

  public void checkBallCountDoubleForConstruction(int[] computerNumber,
      int[] inputNumberArray, int[] returnArray, int length, int i) {
    for (int j = 0; j < length; j++) {
      compareCheckBall(computerNumber, inputNumberArray, returnArray, i, j);
    }
  }

  public int compareArray(int a, int b) {
    if (a == b) {
      return 1;
    }
    return 0;
  }

  public void compareCheckBall(int[] computerNumber, int[] inputNumberArray,
      int[] returnArray, int i, int j) {
    if (j != i) {
      returnArray[1] += compareArray(computerNumber[i], inputNumberArray[j]);
    }
  }

  public void checkStrikeCount(int[] computerNumber, int[] inputNumberArray,
      int[] returnArray, int length) {
    for (int i = 0; i < length; i++) {
      returnArray[0] += compareArray(computerNumber[i], inputNumberArray[i]);
    }
  }

  public String scanningInputNumber() {
    Scanner scn = new Scanner(System.in);
    return scn.nextLine();
  }

  public void setInputNumberToArray(int[] inputNumberArray) {
    System.out.println("숫자를 입력해주세요");
    String inputNumber = scanningInputNumber();
    for (int i = 0; i < inputNumber.length(); i++) {
      inputNumberArray[i] = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
    }
  }

  public void generateRandomNumber(int[] computerNumber) {
    for (int i = 0; i < computerNumber.length; i++) {
      computerNumber[i] = (int) (Math.random() * 9) + 1;
      i -= checkOverlapNumber(computerNumber, i);
    }
  }

  public int checkOverlapNumber(int[] computerNumber, int i) {
    int cnt = 0;
    for (int j = 0; j < i; j++) {
      cnt += compareArray(computerNumber[i], computerNumber[j]);
    }
    if (cnt > 0) {
      return 1;
    }
    return 0;
  }
}
