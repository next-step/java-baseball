package jito.baseball.domain;

import jito.baseball.message.ErrorMessage;
import jito.baseball.util.BaseballException;

public class PlayerBaseBall implements NumberBaseBall {

    private final int[] playerNumbers;

    public PlayerBaseBall(String input) {
        String[] playerInput = input.split("");
        playerNumbers = new int[playerInput.length];
        for (int i = 0; i < playerInput.length; i++) {
            playerNumbers[i] = Integer.parseInt(playerInput[i]);
        }
        checkValidation();
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }

    @Override
    public void isNotOneToNineNumber() {
        for (int number : playerNumbers) {
            if (number < 1 || number > 9) {
                BaseballException.throwException(ErrorMessage.EACH_NUMBER_RANGE_ERROR);
            }
        }
    }

    @Override
    public void isNotThreeDigits() {
        if (playerNumbers.length != 3) {
            BaseballException.throwException(ErrorMessage.DIGITS_ERROR);
        }
    }

    @Override
    public void isDuplicate() {
        if ((playerNumbers[0] == playerNumbers[1] || playerNumbers[0] == playerNumbers[2]) || playerNumbers[1] == playerNumbers[2]) {
            BaseballException.throwException(ErrorMessage.DUPLICATE_ERROR);
        }
    }

    @Override
    public void checkValidation() {
        isNotOneToNineNumber();
        isNotThreeDigits();
        isDuplicate();
    }
}
