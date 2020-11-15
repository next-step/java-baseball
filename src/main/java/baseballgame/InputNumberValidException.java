package baseballgame;

import java.util.List;

public class InputNumberValidException extends RuntimeException {
    private List<String> errorCodes;

    public InputNumberValidException(List<String> errorCodes) {
        super("errors: " + errorCodes);
        this.errorCodes = errorCodes;
    }
}
