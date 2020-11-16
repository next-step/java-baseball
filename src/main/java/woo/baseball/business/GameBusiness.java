package woo.baseball.business;

import java.util.Arrays;
import java.util.List;

import woo.baseball.domain.GameStatus;
import woo.baseball.domain.GameUser;
import woo.baseball.service.InputService;
import woo.baseball.service.UiService;
import woo.baseball.type.InputType;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : 실제 게임을 진행하기위한 클래스
 */

public class GameBusiness {
  private GameUser computer;
  private GameUser human;
  public static int finishNumber = 0;
  /**
   * @author : chano
   * @Date : 2020. 11. 11.
   * @Description : 게임실행로직
   * @Method Name : gameStarter
   * @return : void
   */

  public void gameStart() {
    UiService.inputText();
    computer = new GameUser(InputService.ballNumberGenerator(), GameStatus.GAME_RESET);
    GameStatus.GAME_STATUS = GameStatus.GAME_NUMBER_INPUT;
    while (GameStatus.GAME_STATUS != GameStatus.GAME_EXIT) {
      GameStatus.GAME_STATUS = goGame(inputNumber(GameStatus.GAME_STATUS));
    }
  }
  
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : 스트라이크,볼을 체크할 메소드.
   * @Method Name : strikeBall
   * @return : void
   */
  private void strikeBall() {
    List<String> listHuman= Arrays.asList(human.getStrNumber());
    List<String> listComputer= Arrays.asList(computer.getStrNumber());
    for (int i = 0; i < 3; i++) {
      strikeBallCount(listHuman, listComputer, i);
    }
    
  }
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : strikeBall과 연계되어 사용되는 메소드
   * @Method Name : strikeBallCount
   * @return : void
   */
  public static void strikeBallCount(List<String> listHuman,List<String> listComputer, int i) {
    if (listHuman.contains(listComputer.get(i))&&!listHuman.get(i).equals(listComputer.get(i))) {
      GameStatus.ball++;
    }
    if(listHuman.get(i).equals(listComputer.get(i))) {
      GameStatus.strike++;
    }
   }
 
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : goGame에 대한 연계적인것과 strikeLogic을 호출함으로써 실질적 로직을 호출하는 메소드.
   * @Method Name : checkGame
   * @return : int
   */
  private int callLogic(int status) {
    if(status==GameStatus.GAME_NOT_NUMBER || status==GameStatus.GAME_INVALID_NUMBER||status==GameStatus.GAME_RESET) {
      return GameStatus.GAME_GO;
    }
    strikeLogic();
    if (GameStatus.strike == 3 || status==GameStatus.GAME_NOT_EXIT_RESET_NUMBER) {
      return UiService.success();
    }
    return status;
  }
  
  private void strikeLogic() {
    strikeBall();
    UiService.strikeBall();
  }
  /**
   * @author : chano
   * @Date   : 2020. 11. 16.
   * @Description : inputNumber에서 리턴받은값을 토대로 게임진행여부에대해 체크 및 UI 호출.
   * @Method Name : goGame
   * @return : int
   */
  private int goGame(int humanstatus) {
    int status = callLogic(humanstatus);
    if (status == GameStatus.GAME_CHOOSE_INPUT) {
      return GameStatus.GAME_CHOOSE_INPUT;
    }
    if (status == GameStatus.GAME_GO||status==GameStatus.GAME_RESET) {
      GameStatus.Init();
      UiService.inputText();
    }
       return GameStatus.GAME_NUMBER_INPUT;
  }

  /**
   * @author : chano
   * @Date   : 2020. 11. 15.
   * @Description : 게임시작을위해 입력받는 메소드이다.
   * @Method Name : inputNumber
   * @return : int
   */
  private int inputNumber(int status) {
    if (status == GameStatus.GAME_NUMBER_INPUT) {
      return humanInit(InputService.inputNumber(InputType.BALL_NUMBER));
    }
    if (status == GameStatus.GAME_CHOOSE_INPUT) {
      return computerInit( InputService.inputNumber(InputType.GAME_NUMBER));
    }
    return status;
  }

  private int humanInit(GameUser human) {
    this.human = human;
    return human.getStatus();
  }

  private int computerInit(GameUser computer) {
    this.computer =  computer;
    return computer.getStatus();
  }
}
