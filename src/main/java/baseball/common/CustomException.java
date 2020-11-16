package baseball.common;

public class CustomException extends RuntimeException {

    public static class NumberSizeError extends RuntimeException {
        public NumberSizeError(final String message) {
            super(message);
        }
    }

    public static class NumberTypeError extends RuntimeException {
        public NumberTypeError(final String message) {
            super(message);
        }
    }

    public static class NumberDuplicateError extends RuntimeException {
        public NumberDuplicateError(final String message) {
            super(message);
        }
    }

    public static class RandomNumberMinMaxError extends RuntimeException {
        public RandomNumberMinMaxError(final String message) {
            super(message);
        }
    }

}
