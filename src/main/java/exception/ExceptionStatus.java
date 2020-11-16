package exception;

import lombok.Getter;

@Getter
public enum ExceptionStatus {
    INVALID_BALL_NUMBER("Invalid Ball Number");

    private String message;

    ExceptionStatus(String message) {
        this.message = message;
    }
}
