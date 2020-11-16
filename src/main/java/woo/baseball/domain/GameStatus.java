package woo.baseball.domain;

import java.util.Set;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : 스트라이크,볼 갯수를 관리하는 클래스
 */
public class GameStatus {
  public static int strike = 0;
  public static int ball = 0;
  /**
   * @Description : 숫자를 생성할 NUMBER이며 여기서는 야구게임의 MAX값인 999 이다.
   * @Field : MAX_NUMBER
   */
  public final static int MAX_NUMBER = 999;
  /**
   * @Description : 숫자를 생성할 NUMBER이며 여기서는 야구게임의 MIN값인 100 이다.
   * @Field : MIN_NUMBER
   */
  public final static int MIN_NUMBER = 100;

  private Set<Integer> baseBallNumber = null;

  public Set<Integer> getBaseBallNumber() {
    return baseBallNumber;
  }

  public void setBaseBallNumber(Set<Integer> baseBallNumber) {
    this.baseBallNumber = baseBallNumber;
  }
  public final static int GAME_RESET = 1;
  public final static int GAME_EXIT = 2;
  public final static int GAME_CHOOSE = 3;
  public final static int GAME_GO = 4;
  public final static int GAME_NUMBER_INPUT = 5;
  public final static int GAME_CHOOSE_INPUT = 6;
  public final static int NUMBER_RESET = 7;
  public final static int GAME_NOT_NUMBER = 8;
  public final static int GAME_NOT_EXIT_RESET_NUMBER = 10;
  public final static int GAME_INVALID_NUMBER = 9;
  public final static int GAME_NOT_DIFFRENT_NUMBER = 11;

  public static int GAME_STATUS = GAME_GO;

  public static void Init() {
    GameStatus.strike = 0;
    GameStatus.ball = 0;

  }

}
