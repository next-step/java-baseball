public enum Message {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    INVALID_INPUT("입력이 올바르지 않습니다"),
    PUTIN_NUMBER("숫자를 입력해주세요 : "),
    ALL_STRIKES("개의 숫자를 모두 맞히셨습니다! 게임종료"),
    REPLAY_GUIDE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");


    private final String message;
    Message(String msg) {
        this.message = msg;
    }
    public String getMessage(){return message;}
}
