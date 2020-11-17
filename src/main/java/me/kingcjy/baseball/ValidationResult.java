package me.kingcjy.baseball;

/**
 * @author KingCjy
 */
public enum ValidationResult {
    SUCCESS(""),
    INVALID_LENGTH("3자리 숫자로 입력해주세요."),
    INVALID_INPUT("1~9까지의 숫자를 입력해주세요."),
    DUPLICATED("중복된 숫자를 허용하지 않습니다.");

    private String message;

    ValidationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        if ("".equals(this.message)) {
            return;
        }

        System.out.println(this.message);
    }
}
