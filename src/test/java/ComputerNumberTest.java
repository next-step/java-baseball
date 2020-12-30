import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    BaseballGameNumberChecker checker = new BaseballGameNumberChecker(3);
    ComputerNumber computerNumber = new ComputerNumber(3);

    @Test
    @DisplayName("규칙에 맞는 랜던한 숫자 생성")
    void getNumber() {
        Assertions.assertThat(checker.isCorrect(computerNumber.getNumber())).isTrue();
        Assertions.assertThat(checker.isCorrect(computerNumber.getNumber())).isTrue();
        Assertions.assertThat(checker.isCorrect(computerNumber.getNumber())).isTrue();
        Assertions.assertThat(checker.isCorrect(computerNumber.getNumber())).isTrue();
        Assertions.assertThat(checker.isCorrect(computerNumber.getNumber())).isTrue();
    }

    @Test
    @DisplayName("랜덤한 숫자 생성")
    void makeRandomNumber() {
        Assertions.assertThat(computerNumber.makeRandomNumber()).isPositive();
        Assertions.assertThat(computerNumber.makeRandomNumber()).isPositive();
        Assertions.assertThat(computerNumber.makeRandomNumber()).isPositive();
    }

}