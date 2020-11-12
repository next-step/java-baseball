package ui;

import domain.BaseballNumbers;
import domain.baseballNumber.BaseballNumber;
import ui.exceptions.InvalidSizeException;

import java.util.ArrayList;
import java.util.List;

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

    public BaseballNumbers convertToBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        for (String number : playerBall.split("")) {
            baseballNumbers.add(BaseballNumber.of(Integer.parseInt(number)));
        }

        return new BaseballNumbers(baseballNumbers);
    }
}
