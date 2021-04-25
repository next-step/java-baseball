package camp.nextstep.edu.code;

public enum GameOption implements EnumCode {

    RESTART("1", "게임 새로 시작"),
    EXIT("2", "게임 종료");

    private final String code;
    private final String message;

    GameOption(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
