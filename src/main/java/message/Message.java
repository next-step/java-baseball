package message;

public enum Message {
    INPUT("숫자를 입력해주세요 : "),
    NEW_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

    final private String message;

    private Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
