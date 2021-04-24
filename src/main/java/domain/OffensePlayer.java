package domain;

import view.InputMessage;

public class OffensePlayer {

    private Numbers guessNumbers;
    private InputMessage inputMessage;

    public OffensePlayer(){
        inputMessage = new InputMessage();
    }

    public Numbers makeGuess() {
        guessNumbers = new Numbers();
        char[] input = receiveValidDataFromInput();

        for(int i=0;i<Numbers.MAX_SIZE;i++){
            guessNumbers.getDigits().add(Character.getNumericValue(input[i]));
        }
        return guessNumbers;
    }

    private char[] receiveValidDataFromInput() {
        char[] input = null;
        while(input == null){
            input = inputMessage.getInput();
        }
        return input;
    }

}
