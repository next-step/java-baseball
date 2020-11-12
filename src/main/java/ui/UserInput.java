package ui;

import domain.BaseballNumbers;
import domain.baseballNumber.BaseballNumber;
import ui.exceptions.InvalidSizeException;

import java.util.*;

public class UserInput {
    private String playerBall;

    public UserInput(String playerBall) {
        validateSize(playerBall);
        this.playerBall = playerBall;
    }

    public BaseballNumbers convertToBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        for (String number : playerBall.split("")) {
            baseballNumbers.add(BaseballNumber.of(Integer.parseInt(number)));
        }

        return new BaseballNumbers(baseballNumbers);
    }

    private void validateSize(String playerBall) {
        if (removeDup(playerBall).size() != 3) {
            throw new InvalidSizeException();
        }
    }

    private Set<String> removeDup(String source) {
        List<String> splitString = Arrays.asList(source.split(""));
        return new HashSet<>(splitString);
    }
}
