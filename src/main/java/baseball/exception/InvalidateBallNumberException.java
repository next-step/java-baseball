package baseball.exception;

public class InvalidateBallNumberException extends RuntimeException {

    public InvalidateBallNumberException(String message) {
        super(message);
    }

    public static class InvalidateBallNumberSizeError extends InvalidateBallNumberException {
        public InvalidateBallNumberSizeError(final String message) {
            super(message);
        }
    }

    public static class InvalidateBallNumberValueError extends InvalidateBallNumberException {
        public InvalidateBallNumberValueError(final String message) {
            super(message);
        }
    }
}
