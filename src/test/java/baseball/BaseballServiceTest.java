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

    @Test
    public void When_InputValueHas0AndNotIn111to999_Expect_ValidateInputValueAsFalse() {
        softly = new SoftAssertions();

        softly.assertThat(baseballService.validateInputValue(210)).as("InputValueHas0").isFalse();
        softly.assertThat(baseballService.validateInputValue(97)).as("InputValueLessThan111").isFalse();
        softly.assertThat(baseballService.validateInputValue(1052)).as("InputValueOverThan999").isFalse();
        softly.assertAll();
    }

    @Test
    public void When_InputValueHasDuplicateNumber_Expect_ValidateInputValueAsFalse() {
        softly = new SoftAssertions();

        softly.assertThat(baseballService.validateInputValue(112)).as("InputValueHasDuplicateNumber").isFalse();
        softly.assertAll();
    }

}
