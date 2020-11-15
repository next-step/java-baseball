package domain;

import exception.DuplicateNumberOfDigitException;
import exception.InvalidNumberOfDigitRange;
import exception.NumberNotThreeDigitsException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NumberTest {

    @Test
    @Order(1)
    @DisplayName("상대방(컴퓨터)가 생성한 숫자가 3자리인지 확인")
    public void playerNumberShouldBeNumberOfThreeDigits() {
        Number playerNumber = new Number();
        assertTrue(playerNumber.isNumberOfThreeDigits());
    }

    @Test
    @Order(2)
    @DisplayName("상대방(컴퓨터)가 생성한 숫자의 각 자릿수가 1에서 9사이의 값인지 확인")
    public void playerNumberOfDigitShouldBeBetweenOneAndNine() {
        Number playerNumber = new Number();
        assertTrue(playerNumber.isNumberOfDigitBetweenOneToNine());
    }

    @Test
    @Order(3)
    @DisplayName("상대방(컴퓨터)가 생성한 숫자의 각 자릿수가 서로 다른지 확인")
    public void playerNumberOfDigitShouldBeDifferentEachOther() {
        Number playerNumber = new Number();
        assertTrue(playerNumber.isNumberOfDigitDifferentEachOther());
    }

    @Test
    @Order(4)
    @DisplayName("사용자가 입력한 숫자가 3자리가 아니면 예외 발생")
    public void userNumberShouldBeNumberOfThreeDigits() {
        assertThrows(NumberNotThreeDigitsException.class, () -> new Number(12));
    }

    @Test
    @Order(5)
    @DisplayName("사용자가 입력한 숫자의 각 자릿수가 1에서 9사이의 값이 아니면 예외 발생")
    public void userNumberOfDigitShouldBeBetweenOneAndNine() {
        assertThrows(InvalidNumberOfDigitRange.class, () -> new Number(102));
    }

    @Test
    @Order(6)
    @DisplayName("사용자가 입력한 숫자의 각 자릿수가 중복되면 예외 발생")
    public void userNumberOfDigitShouldBeDifferentEachOther() {
        assertThrows(DuplicateNumberOfDigitException.class, () -> new Number(112));
    }

    @Test
    @Order(7)
    @DisplayName("사용자가 입력한 숫자가 유효한 값인지 확인")
    public void userNumberShouldBeValid() {
        Number userNumber = new Number(123);
        assertAll(
                () -> assertTrue(userNumber.isNumberOfThreeDigits()),
                () -> assertTrue(userNumber.isNumberOfDigitBetweenOneToNine()),
                () -> assertTrue(userNumber.isNumberOfDigitDifferentEachOther()));
    }
}
