package precourse.baseball.printer;

public enum PrintMessage {

  ENTER_NUMBER("숫자를 입력해주세요 : "),
  GAME_RESTART_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
  STRIKE("스트라이크"),
  BALL("볼"),
  GAME_STOP("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
  NOTHING("낫싱");

  private final String message;

  public String getMessage() {
    return message;
  }

  PrintMessage(String message) {
    this.message = message;
  }
}
