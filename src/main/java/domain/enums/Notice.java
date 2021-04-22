package domain.enums;

public enum Notice {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ALL_NUMBER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_GAME_AGAIN("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}