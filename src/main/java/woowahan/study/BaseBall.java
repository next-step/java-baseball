package woowahan.study;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {

  private final String[] randomData;
  private Scanner scanner;

  public BaseBall() {
    this.randomData = this.getRandomText();
    this.scanner = new Scanner(System.in);
  }

  public void play() {
    System.out.println("숫자를 입력해주세요 :");
    try {
      String inputDataStr = scanner.next();

      if (inputDataStr.length() != 3) {
        System.out.println("입력 값은 3자리의 자연수를 입력하여야 합니다.");
        play();
      }

      int strike = 0;
      int ball = 0;
      for (int t = 0; t < randomData.length; t++) {
        strike += isStrike(inputDataStr, t);
        ball += isBall(inputDataStr, t);
      }

      System.out.println(writeMessage(strike, ball));
      if (strike == 3) {
        resetGame();
      }
      play();
    } catch (Exception e) {
      System.out.println("게임진행에 실패하였습니다. 원인: ".concat(e.getMessage()));
      exitGame();
    }
  }

  /**
   * 랜덤텍스트 생성
   * : 상대방(컴퓨터) 수 생성
   */
  public String[] getRandomText() {
    Random fixRandomCount = new Random();
    Set<String> randomDataSet = new HashSet<>();
    do {
      String randomInt = Integer.toString(fixRandomCount.nextInt(10));
      randomDataSet.add(randomInt);
    } while (randomDataSet.size() < 3);
    String[] randomText = new String[randomDataSet.size()];
    randomDataSet.toArray(randomText);

    return randomText;
  }

  /**
   * 스트라이크 여부 카운트
   */
  public int isStrike(String inputData, int idx) {
    if (randomData[idx].equals(inputData.substring(idx,idx+1))) {
      return 1;
    }
    return 0;
  }

  /**
   * 볼 여부 카운트
   */
  public int isBall(String inputData, int idx) {
    if (isStrike(inputData, idx) == 0) {
      return inputData.contains(randomData[idx]) ? 1 : 0;
    }
    return 0;
  }

  /**
   * 판독결과 메세지 반환
   */
  public String writeMessage(int strike, int ball) {
    if (strike == 3) {
      return "3개의 숫자를 모두 맞히셨습니다! 게임종료!";
    }
    if (strike == 0 && ball == 0) {
      return "낫싱";
    }
    return strike + " 스트라이크 " + ball + " 볼";
  }

  /**
   * 리셋처리
   */
  public void resetGame() {
    System.out.println("개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String selected = scanner.next();

    if (selected.equals("1")) {
      GameStart.main(null);
    }
    if (selected.equals("2")) {
      exitGame();
    }
    resetGame();
  }

  /**
   * 종료처리
   */
  private void exitGame() {
    if (scanner != null) {
      scanner.close();
    }
    System.exit(0);
  }

}
