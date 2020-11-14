package jito.baseball.domain;

public enum GameStatus {
    GAME("PLAY");

    private static final String END = "END";
    private String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setEnd() {
        this.status = END;
    }
}
