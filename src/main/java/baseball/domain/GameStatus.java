package baseball.domain;

public enum GameStatus {

    CONTINUE(1),
    END(2);

    private int code;

    GameStatus(int code) {
        this.code = code;
    }

    public boolean equalsCode(final int target) {
        return this.code == target;
    }

}
