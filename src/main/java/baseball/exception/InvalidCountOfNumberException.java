package baseball.exception;

import baseball.model.Numbers;

public class InvalidCountOfNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "Number 의 갯수는 %d 개를 만족해야 합니다. (입력 갯수: %d)";

    public InvalidCountOfNumberException(final int inputCountOfLottoNumber) {
        super(String.format(ERROR_MESSAGE, Numbers.COUNT_OF_NUMBER, inputCountOfLottoNumber));
    }
}
