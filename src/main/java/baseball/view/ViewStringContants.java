package baseball.view;

public enum ViewStringContants {
    INPUT_NUMBERS("숫자를 입력해 주세요 : "),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_REGAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


    private String message;
    ViewStringContants(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
