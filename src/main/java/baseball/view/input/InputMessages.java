package baseball.view.input;

import baseball.domain.Number;
import baseball.domain.Numbers;

public class InputMessages {
    public static final String PLEASE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String PLEASE_INPUT_VALID_NUMBERS = Number.MIN_VALUE + "부터 " + Number.MAX_VALUE + "까지의 숫자 중 서로다른 " + Numbers.SIZE + "자리 수를 입력해주세요";
}
