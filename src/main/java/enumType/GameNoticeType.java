package enumType;

public enum GameNoticeType {

     INPUT_REQUEST        ("숫자를 입력해주세요 : ")
    ,GAME_WIN_MESSAGE     ("3개의 숫자를 모두 맞히셨습니다! 게임종료")
    ,GAME_RESTART_INQUIRE ("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    
    private String message;
    
    GameNoticeType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
