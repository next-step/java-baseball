package ui;

import ui.exceptions.InvalidSizeException;

public class UserInput {
    private String playerBall;

    public UserInput(String playerBall) {
        validateSize(playerBall);
        this.playerBall = playerBall;
    }

    private void validateSize(String playerBall) {
        if (playerBall.length() != 3) {
            throw new InvalidSizeException();
        }
    }
}
