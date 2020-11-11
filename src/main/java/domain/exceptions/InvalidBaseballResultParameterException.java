package domain.exceptions;

public class InvalidBaseballResultParameterException extends RuntimeException {
    public InvalidBaseballResultParameterException(String message) {
        super(message);
    }
}
