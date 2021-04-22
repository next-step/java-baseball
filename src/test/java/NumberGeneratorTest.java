import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    private static final int TEST_TRIAL = 1000;

    @DisplayName("1~9로 이루어진 n자리 숫자를 잘 만들어내는지 확인")
    @Test
    void 숫자_생성() {
        for (int i = 0; i < TEST_TRIAL; i++) {
            //when
            String number = NumberGenerator.generateNumber(GameOptions.HOW_MANY_DIGIT);
            //then
            assertThat(number.length()).isEqualTo(GameOptions.HOW_MANY_DIGIT);
            assertThat(number).containsPattern(Pattern.compile("[1-9]{" + GameOptions.HOW_MANY_DIGIT + "}"));
        }

    }

    @DisplayName("1~9로 이루어진 1자리 숫자를 잘 만들어내는지 확인")
    @Test
    void 숫자_한개_생성() {

        for (int i = 0; i < TEST_TRIAL; i++) {
            //when
            int digit = NumberGenerator.generateDigit();
            //then
            assertThat(digit).isGreaterThan(0).isLessThan(10);
        }

    }

}
