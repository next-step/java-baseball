package woo.baseball.business;

import java.util.Scanner;

import woo.baseball.domain.GameStatus;
import woo.baseball.domain.GameUser;
import woo.baseball.service.InputService;
import woo.baseball.service.UiService;

/**
 * @author : chano
 * @Date : 2020. 11. 13.
 * @Description :
 */
public class InputBusiness {
  private static int inputnumber = 0;
  
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : 야구게임 3자리 숫자를입력받고 잘못된 값을 입력받으면 GAME_NOT_NUMBER 리턴
   * @Method Name : checkBaseBallNumber
   * @return : GameUser
   */
  public static GameUser checkBaseBallNumber(Scanner sc) {
    try {
      inputnumber = sc.nextInt();
      return digitBaseballNumber(inputnumber);
    } catch (Exception e) {
      UiService.notNumberExeption();
      return new GameUser(inputnumber, GameStatus.GAME_NOT_NUMBER);
    }
  }
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : 게임진행에 쓰일 목적으로 필요한 숫자를 입력받고 잘못된 값을 입력받으면 GAME_NOT_EXIT_RESET_NUMBER 리턴
   * @Method Name : checkGameRunNumber
   * @return : GameUser
   */
  public static GameUser checkGameRunNumber(Scanner sc) {
    try {
      inputnumber = sc.nextInt();
      return digitGameRunNumber(inputnumber);
    } catch (Exception e) {
      UiService.notNumberExeption();
      return new GameUser(GameStatus.GAME_NOT_EXIT_RESET_NUMBER);
    }
  }
  
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : 컴퓨터의 숫자가 필요하면 매개변수를 통하여 RESET,EXIT여부를 확인함.
   * @Method Name : digitGameRunNumber
   * @return : GameUser
   */
  private static GameUser digitGameRunNumber(int number) {
    int computernumber=InputService.ballNumberGenerator();
      if(number==GameStatus.GAME_EXIT) {
        System.exit(0);
     }
    if(number==GameStatus.GAME_RESET) {
      return new GameUser(computernumber, GameStatus.GAME_RESET);
    }
   UiService.notGameNumberExeption();
   return new GameUser(GameStatus.GAME_NOT_EXIT_RESET_NUMBER); 
  }
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : 사용자 숫자를 입력받을때마다 이함수로 VALIDATION을 체크함.
   * @Method Name : digitBaseballNumber
   * @return : GameUser
   */
  public static GameUser digitBaseballNumber(int baseBallNumber) {
    if((GameStatus.MIN_NUMBER <= baseBallNumber && GameStatus.MAX_NUMBER >= baseBallNumber)&&InputService.validDistinctNumber(baseBallNumber)) {
      return new GameUser(baseBallNumber, GameStatus.GAME_GO);
    }
    UiService.noBaseballNumberExeption();
    return new GameUser(baseBallNumber, GameStatus.GAME_INVALID_NUMBER);
  }
 
}
