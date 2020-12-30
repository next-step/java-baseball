import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BaseballGameNumberCheckerTest {

    BaseballGameNumberChecker checker = new BaseballGameNumberChecker(3);

    @Test
    @DisplayName("올바른 숫자인제 체크")
    void isCorrect() {
        Assertions.assertThat(checker.isCorrect(123)).isTrue();
        Assertions.assertThat(checker.isCorrect(693)).isTrue();
        Assertions.assertThat(checker.isCorrect(112)).isFalse();
        Assertions.assertThat(checker.isCorrect(904)).isFalse();
        Assertions.assertThat(checker.isCorrect(45)).isFalse();
        Assertions.assertThat(checker.isCorrect(4596)).isFalse();
    }

    @Test
    @DisplayName("숫자의 길이 체크")
    void checkLength() {
        Assertions.assertThat(checker.checkLength(123)).isTrue();
        Assertions.assertThat(checker.checkLength(306)).isTrue();
        Assertions.assertThat(checker.checkLength(3952)).isFalse();
        Assertions.assertThat(checker.checkLength(35)).isFalse();
        Assertions.assertThat(checker.checkLength(0)).isFalse();
    }

    @Test
    @DisplayName("중복된 숫자 체크")
    void checkDup() {
        org.assertj.core.api.Assertions.assertThat(checker.checkDup(112)).isFalse();
        org.assertj.core.api.Assertions.assertThat(checker.checkDup(373)).isFalse();
        org.assertj.core.api.Assertions.assertThat(checker.checkDup(222)).isFalse();
        org.assertj.core.api.Assertions.assertThat(checker.checkDup(357)).isTrue();
        org.assertj.core.api.Assertions.assertThat(checker.checkDup(123)).isTrue();
    }

    @Test
    @DisplayName("0을 포함하는지 체크")
    void checkZero() {
        Assertions.assertThat(checker.checkZero(102)).isFalse();
        Assertions.assertThat(checker.checkZero(120)).isFalse();
        Assertions.assertThat(checker.checkZero(603)).isFalse();
        Assertions.assertThat(checker.checkZero(483)).isTrue();
        Assertions.assertThat(checker.checkZero(932)).isTrue();
    }
}