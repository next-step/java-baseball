package woo.baseball.service;

import woo.baseball.domain.GameStatus;
import woo.baseball.type.UiType;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : 모든 출력에관한 기능을 여기서 메서드로 설정한다.
 */
public class UiService {
  private static String strikeball = "";

  public static void inputText() {
    printUi(UiType.INPUT_TEXT.text(), false);
  }

  public static String strike(int strike) {
    return strike + UiType.STRIKE.text();
  }

  public static String ball(int ball) {
    return ball + UiType.BALL.text();
  }

  public static int success() {
    printUi(UiType.SUCCESS_TEXT.text(), true);
    return GameStatus.GAME_CHOOSE_INPUT;
  }

  public static void noBaseballNumberExeption() {
    String text = "";
    text += UiType.NO_NUMBER.text();
    printUi(text, true);
  }
  public static void notGameNumberExeption() {
    String text = "";
    text += UiType.NOT_GAME_RUN.text();
    printUi(text, true);
  }
  public static void notNumberExeption() {
    String text = "";
    text += UiType.NOT_NUMBER.text();
    printUi(text, true);
  }

  public static void println() {
    System.out.println();
  }

  public static void strikeBall() {
    strikeball = "";
    if (GameStatus.strike != 0) {
      strikeball += strike(GameStatus.strike);
    }
    if (GameStatus.ball != 0) {
      strikeball += ball(GameStatus.ball);
    }
    printUi(strikeball, true);
  }
  
  public static void printUi(String text, boolean line) {
    if (text.equals("")) {
      text += UiType.NOTHING.text();
    }
    System.out.print(text);
    if (line) {
      println();
    }
  }
}
