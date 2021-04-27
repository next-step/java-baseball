package dev.cobi.view;

import java.util.Scanner;

import dev.cobi.domains.ResultScore;

/**
 * @author cobiyu
 */
public class BaseballGameView {
  private final Scanner scanner = new Scanner(System.in);
  private final static String RESTART = "1";
  private final static String QUIT = "2";

  /**
   * 숫자 입력
   * 
   * @return 입력한 숫자
   */
  public String inputPlayNumber() {
    System.out.println("숫자를 입력해주세요. : ");
    
    return String.valueOf(scanner.nextInt());
  }

  /**
   * 결과 출력
   * 
   * @param resultScore 결과 정보
   */
  public void displayResult(ResultScore resultScore) {
    System.out.println(resultScore);
    
    printGameOver(resultScore);
  }

  /**
   * 게임 종료 message 출력
   * 
   * @param resultScore 결과 정보
   */
  public void printGameOver(ResultScore resultScore){
    if(resultScore.isCorrect()){
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
  }

  /**
   * 게임 재시작
   * 
   * @return 재시작 여부
   */
  public boolean isRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String restartNumber = scanner.nextLine();

    if (restartNumber.equals(RESTART)) {
      return true;
    }

    if (restartNumber.equals(QUIT)) {
      return false;
    }

    throw new IllegalArgumentException();
  }
}
