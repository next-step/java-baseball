package me.totoku103.baseball;

import java.util.Objects;

public class BaseballSystem {

    private String generatedRandomString;

    public BaseballSystem(String generatedRandomString) {
        this.generatedRandomString = generatedRandomString;
    }

    public boolean validate(String userInput) {
        System.out.println(this.checkCountStrike(userInput) + ":" + MessageConstants.STRIKE + " " + this.checkCountBall(userInput) + ":" + MessageConstants.BALL);
        return this.checkGameEnd(userInput);
    }

    private boolean checkGameEnd(String userInput) {
        return Objects.equals(this.generatedRandomString, userInput);
    }

    private int checkCountStrike(String userInput) {
        int resultStrikeCount = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Objects.equals(this.generatedRandomString.charAt(i), userInput.charAt(i))) resultStrikeCount++;
        }
        return resultStrikeCount;
    }

    private int checkCountBall(String userInput) {
        int resultBallCount = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (!Objects.equals(this.generatedRandomString.charAt(i), userInput.charAt(i))
                    && this.generatedRandomString.contains(String.valueOf(userInput.charAt(i)))) resultBallCount++;
        }
        return resultBallCount;
    }
}
