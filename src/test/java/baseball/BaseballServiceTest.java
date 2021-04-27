package baseball;

import baseball.BaseballService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballServiceTest {

    BaseballService baseballService = new BaseballService();
    SoftAssertions softly = new SoftAssertions();

    @Test
    public void When_CreateNumber_Expect_EachNumberNotDuplicateNotZero() {

        Number number = baseballService.createRandomNumber();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(number.getFirstNumber()).as("firstNumber")
                .isNotZero().isNotEqualTo(number.getSecondNumber())
                .isNotEqualTo(number.getThirdNumber());
        softly.assertThat(number.getSecondNumber()).as("secondNumber")
                .isNotZero().isNotEqualTo(number.getFirstNumber())
                .isNotEqualTo(number.getThirdNumber());
        softly.assertThat(number.getThirdNumber()).as("thirdNumber")
                .isNotZero().isNotEqualTo(number.getFirstNumber())
                .isNotEqualTo(number.getSecondNumber());
        softly.assertAll();

    }

}
