package view;

public class ErrorMessage {
    private static final String INPUT_NUM_VALIDATION_ERROR = "올바른 세 자리 숫자를 입력해 주세요.";
    private static final String CHECK_RESTART_NUM_ERROR = "올바른 값을 입력해 주세요.";

    public void inputNumValidError() {
        System.out.println(INPUT_NUM_VALIDATION_ERROR);
    }

    public void checkRestartNumError() {
        System.out.println(CHECK_RESTART_NUM_ERROR);
    }
}
