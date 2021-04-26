package homework.baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationCheckerTest {

    @Test
    public void correctFormatForAnswerTest() {
        System.out.println("\r\ncorrectFormatForAnswerTest 실행");
        System.out.print("1234: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("1234")).isFalse();
        System.out.print("5634: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("5634")).isFalse();
        System.out.print("1234^: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("1234^")).isFalse();
        System.out.print("3S4: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("3S4")).isFalse();
        System.out.print("1C4: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("1C4")).isFalse();
        System.out.print("14d: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("14d")).isFalse();
        System.out.print("14#: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("14#")).isFalse();
        System.out.print("112: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("112")).isFalse();
        System.out.print("122: ");
        assertThat(ValidationChecker.isCorrectFormatForAnswer("122")).isFalse();

        assertThat(ValidationChecker.isCorrectFormatForAnswer("923")).isTrue();
        assertThat(ValidationChecker.isCorrectFormatForAnswer("536")).isTrue();
        assertThat(ValidationChecker.isCorrectFormatForAnswer("641")).isTrue();
        assertThat(ValidationChecker.isCorrectFormatForAnswer("437")).isTrue();
    }

    @Test
    public void correctFormatForRetryTest() {
        System.out.println("\r\ncorrectFormatForRetryTest 실행");
        System.out.print("123A: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("123A")).isFalse();
        System.out.print("12: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("12")).isFalse();
        System.out.print("1A: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("1A")).isFalse();
        System.out.print("1c: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("1c")).isFalse();
        System.out.print("10: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("10")).isFalse();
        System.out.print("1!: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("1!")).isFalse();
        System.out.print("2C: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("2C")).isFalse();
        System.out.print("a: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("a")).isFalse();
        System.out.print("3: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("3")).isFalse();
        System.out.print("A: ");
        assertThat(ValidationChecker.isCorrectFormatForRetry("A")).isFalse();

        assertThat(ValidationChecker.isCorrectFormatForRetry("1")).isTrue();
        assertThat(ValidationChecker.isCorrectFormatForRetry("2")).isTrue();
    }
}
