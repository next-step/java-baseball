package message;

public enum Message {
    INPUT("숫자를 입력해주세요 : "),
    GAME_START("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    final private String message;

    private Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
