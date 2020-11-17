package org.dhlee.game.baseball.exception;

public class InputNumberException extends RuntimeException{
    InputNumberException(){
        super();
    }
    public InputNumberException(String message){
        super(message);
    }
}
