package exception;

public class NotNumberException extends RuntimeException {
    private String message = "숫자를 입력해주시기 바랍니다.";

    public String getMessage() {
        return message;
    }
}
