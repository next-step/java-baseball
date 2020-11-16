package baseball.exception;

public class CustomException extends RuntimeException {

    public static class InvalidateNumberConditionError extends RuntimeException {
        public InvalidateNumberConditionError(final String message) {
            super(message);
        }
    }

    public static class InvalidateNumberSizeError extends RuntimeException {
        public InvalidateNumberSizeError(final String message) {
            super(message);
        }
    }

    public static class InvalidateNumberTypeError extends RuntimeException {
        public InvalidateNumberTypeError(final String message) {
            super(message);
        }
    }

    public static class InvalidateNumberDuplicateError extends RuntimeException {
        public InvalidateNumberDuplicateError(final String message) {
            super(message);
        }
    }

    public static class InvalidateRandomNumberMinMaxError extends RuntimeException {
        public InvalidateRandomNumberMinMaxError(final String message) {
            super(message);
        }
    }

}
