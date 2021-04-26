package domain.participants;

import domain.Numbers;
import domain.game.GameStatus;
import view.InputMessage;

public class OffensePlayer {

    private Numbers guessNumbers;
    private InputMessage inputMessage;

    public OffensePlayer() {
        inputMessage = new InputMessage();
    }

    public Numbers makeGuess() {
        guessNumbers = new Numbers();
        char[] input = receiveValidDataFromInput();

        for (int i=0; i<Numbers.MAX_SIZE; i++) {
            guessNumbers.add(Character.getNumericValue(input[i]));
        }
        return guessNumbers;
    }

    private char[] receiveValidDataFromInput() {
        char[] input = null;
        while (input == null) {
            input = inputMessage.getInput();
        }
        return input;
    }

    public int decideWhetherContinueGame() {
        int code;
        do {
            code = inputMessage.getDecisionCode();
        } while (code != GameStatus.ONGOING.getCode() && code != GameStatus.FINISHED.getCode());
        return code;
    }
}
