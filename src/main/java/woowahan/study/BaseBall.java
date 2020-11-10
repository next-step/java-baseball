package woowahan.study;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class BaseBall {

  private final String[] randomData;

  BaseBall() {
    this.randomData = this.getRandomText();
  }

  void play() throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("숫자를 입력해주세요 :");

    String inputDataStr = scanner.next();
    if (inputDataStr == null || inputDataStr.length() != 3) {
      throw new Exception("[필수] 입력값은 자릿수 3자리입니다.");
    }

    int strike = 0;
    int ball = 0;
    for (int t=0; t<randomData.length; t++) {
      strike += isStrike(inputDataStr, t);
      ball += isBall(inputDataStr, t);
    }

    System.out.println(writeMessage(strike, ball));
    if (strike == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료!");
      System.out.println("개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

      resetGame(scanner.next());
    }
    play();
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
    if (strike == 0 && ball == 0) {
      return "낫싱";
    }
    return strike + " 스트라이크 " + ball + " 볼";
  }

  /**
   * 리셋 및 종료 처리
   * @param selected 1: 새로시작 / 2: 종료
   */
  public void resetGame(String selected) {
    if (selected.equals("2")) {
      System.exit(0);
    }
    GameStart.main(null);
  }

}
