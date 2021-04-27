package com.woowahan.precourse.baseball;

public class GameResult {
    private boolean victory;
    private String message;

    public GameResult() {
        this.victory = false;
    }

    public boolean getVictory() {
        return this.victory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }
}
