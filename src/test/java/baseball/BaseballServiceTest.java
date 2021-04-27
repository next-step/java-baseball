package baseball;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void When_NumberInHundredsDigitWithPosition_Expect_ReturnUnitDigitAtPosition() {
        softly = new SoftAssertions();

        softly.assertThat(baseballService.readNumberByPosition(489, 1)).as("NumberOfFirstPosition").isEqualTo(4);
        softly.assertThat(baseballService.readNumberByPosition(489, 2)).as("NumberOfSecondPosition").isEqualTo(8);
        softly.assertThat(baseballService.readNumberByPosition(489, 3)).as("NumberOfThirdPosition").isEqualTo(9);
        softly.assertAll();
    }

    @Test
    public void When_InputValueWithNumber1samePositionAnd2differPosition_Expect_SetReferee1strike2ball() {
        softly = new SoftAssertions();
        Referee referee = new Referee();
        Number number = new Number(1, 5, 4);

        baseballService.compareNumber(referee, number, 145);

        softly.assertThat(referee.getStrike()).as("1countStrike").isEqualTo(1);
        softly.assertThat(referee.getBall()).as("2countBall").isEqualTo(2);
        softly.assertAll();
    }

    @Test
    public void When_1strike2ball_Expect_Return1strike2ballResult() {
        softly = new SoftAssertions();
        Referee referee = new Referee();

        referee.addStrike();
        referee.addBall();
        referee.addBall();

        softly.assertThat(baseballService.setResult(referee)).as("RefereeHas1strike2ball").isEqualTo("1스트라이크 2볼 ");
        softly.assertAll();
    }

}
