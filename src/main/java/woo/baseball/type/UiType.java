package woo.baseball.type;

/**
 * @author : chano
 * @Date   : 2020. 11. 11.
 * @Description : 출력에 필요한 문자열들 정의.
 */
public enum UiType {
  INPUT_TEXT("숫자를 입력해주세요 : "),
  SUCCESS_TEXT("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
  STRIKE("스트라이크"),
  BALL("볼"),
  NOTHING("낫싱"),
  NOT_NUMBER("숫자가 아닙니다."),
  NOT_GAME_RUN("1~2사이 값을 입력해주세요."),
  NO_NUMBER("서로다른 숫자 100~999 사이를 입력하세요.");
  
  
  private final String text;
  
  UiType(String text){
    this.text=text;
  }
  public String text() {
    return this.text;
  }
  
}
