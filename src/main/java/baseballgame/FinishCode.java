package baseballgame;

enum FinishCode {
    NEW_GAME(1, "새 게임"),
    FINISH(2, "게임 종료");

    private int code;
    private String description;

    FinishCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }
}
