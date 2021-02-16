package domain;

import java.util.List;

public class Round {
    public static final String THREE_STRIKE = "3스트라이크";
    private boolean isFinished;

    public Round() {
        this.isFinished = false;
    }

    public boolean isNot3Strike() {
        return !isFinished;
    }

    public void setResult(List<String> result) {
        if (result.contains(THREE_STRIKE)) {
            isFinished = true;
        }
    }
}
