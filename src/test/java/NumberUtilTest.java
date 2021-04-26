import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilTest {
    private static final NumberUtil numberUtil = new NumberUtil();

    @Test
    @DisplayName("랜덤 숫자 생성 유효 범위 테스트")
    void correctRandomNumberTest() {
        int randomNumber = Integer.parseInt(numberUtil.generateRandomNumber().getNumber());

        assertTrue(randomNumber > 122);
        assertTrue(randomNumber < 988);
    }
}
