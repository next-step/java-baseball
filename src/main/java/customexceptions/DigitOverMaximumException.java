package customexceptions;

public class DigitOverMaximumException extends RuntimeException {
    public DigitOverMaximumException(String message){
        super(message);
    }
}
