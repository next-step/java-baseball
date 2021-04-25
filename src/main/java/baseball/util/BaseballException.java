package baseball.util;

import static baseball.domain.enums.ErrorMessage.*;

public class BaseballException extends RuntimeException {
    private BaseballException(String message) {
        super(message);
    }
    public static class IllegalPlayerInputType extends BaseballException {
        public IllegalPlayerInputType() {
            super(MESSAGE_NUMERIC_ONLY.getMessage());
        }
    }

    public static class IllegalPlayerInputLength extends BaseballException {
        public IllegalPlayerInputLength() {
            super(MESSAGE_INVALID_INPUT_LENGTH.getMessage());
        }
    }

    public static class IllegalPlayerInputBoundary extends BaseballException {
        public IllegalPlayerInputBoundary() {
            super(MESSAGE_INVALID_NUMERIC_BOUNDARY.getMessage());
        }
    }

    public static class IllegalDuplicatePlayerInput extends BaseballException {
        public IllegalDuplicatePlayerInput() {
            super(MESSAGE_DUPLICATE_INPUT.getMessage());
        }
    }


}
