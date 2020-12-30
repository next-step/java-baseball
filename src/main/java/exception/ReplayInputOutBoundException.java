package exception;

public class ReplayInputOutBoundException extends RuntimeException{

    public ReplayInputOutBoundException(){
        super();
    }

    public ReplayInputOutBoundException(String message){
        super(message);
    }
}
