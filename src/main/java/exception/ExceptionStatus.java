package exception;

import lombok.Getter;

@Getter
public enum ExceptionStatus {
    INVALID_BALL_NUMBER("Invalid Ball Number"),
    EXCEEDED_NUMBER_OF_BALL("Exceeded the number of balls");

    private String message;

    ExceptionStatus(String message) {
        this.message = message;
    }
}
