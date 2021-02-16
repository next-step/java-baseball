package domain;

import java.util.List;

public class Round {
    private boolean isFinished;

    public Round() {
        this.isFinished = false;
    }

    public boolean isNot3Strike() {
        return !isFinished;
    }

    public void setResult(List<String> result) {
        if (result.contains("3스트라이크")) {
            isFinished = true;
        }
    }
}
