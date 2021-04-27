package validate;

import baseball.Inning;
import baseball.convert.BaseBallConvert;
import baseball.convert.BaseBallNumberConvert;
import baseball.match.BaseBallInningPlay;
import baseball.match.BaseBallPlay;
import baseball.validate.BaseBallThreeNumberValidate;
import baseball.validate.BaseBallValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BastBallValidateTest {
    @Test
    @DisplayName("숫자를 1개 입력받을때 false를 반환한다.")
    public void checkThreeNumberByOneTest() {
        int[] source = {1};
        BaseBallValidate baseBallValidate = new BaseBallThreeNumberValidate();
        assertThat(baseBallValidate.valid(source)).isFalse();
    }

    @Test
    @DisplayName("숫자를 2개 입력받을때 false를 반환한다.")
    public void checkThreeNumberByTwoTest() {
        int[] source = {1, 2};
        BaseBallValidate baseBallValidate = new BaseBallThreeNumberValidate();
        assertThat(baseBallValidate.valid(source)).isFalse();
    }

    @Test
    @DisplayName("숫자를 3개 입력받을때 true를 반환한다.")
    public void checkThreeNumberByThreeTest() {
        int[] source = {1, 2, 3};
        BaseBallValidate baseBallValidate = new BaseBallThreeNumberValidate();
        assertThat(baseBallValidate.valid(source)).isTrue();
    }

    @Test
    @DisplayName("숫자를 4개 입력받을때 false를 반환한다.")
    public void checkThreeNumberByFourTest() {
        int[] source = {1, 2, 3, 4};
        BaseBallValidate baseBallValidate = new BaseBallThreeNumberValidate();
        assertThat(baseBallValidate.valid(source)).isFalse();
    }

    @Test
    @DisplayName("숫자를 5개 입력받을때 false를 반환한다.")
    public void checkThreeNumberByFiveTest() {
        int[] source = {1, 2, 3, 4, 5};
        BaseBallValidate baseBallValidate = new BaseBallThreeNumberValidate();
        assertThat(baseBallValidate.valid(source)).isFalse();
    }


}
