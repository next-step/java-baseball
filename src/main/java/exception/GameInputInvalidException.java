package exception;

public class GameInputInvalidException extends RuntimeException{

    public GameInputInvalidException(){
        super();
    }

    public GameInputInvalidException(String message){
        super(message);
    }
}
