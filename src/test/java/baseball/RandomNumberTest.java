package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RandomNumberTest {
    private static final RandomNumber random = new RandomNumber();

    @DisplayName("createNumber() : 생성한 난수가 NULL이 아닌지 확인")
    @Test
    void testIsNotNullRandomNumber() {
        int randomNumber = random.createNumber();

        assertThat(randomNumber).isNotNull();
    }

    @DisplayName("createNumber() : 생성한 난수가 3자리의 수인지 확인")
    @Test
    void testIs3DigitsNubmer() {
        int randomNumber = random.createNumber();

        assertThat(randomNumber).isBetween(100, 999);
    }

    @DisplayName("createNumber() : 생성한 난수의 자리수가 같지 않은지 확인")
    @Test
    void testSameDigitsNumber() {
        int randomNumber = random.createNumber();
        int hundred = randomNumber % 1000;
        int ten = randomNumber % 100;
        int one = randomNumber % 10;

        assertThat(hundred).isNotEqualTo(ten);
        assertThat(ten).isNotEqualTo(one);
        assertThat(one).isNotEqualTo(hundred);
    }

    @DisplayName("checkDigit : 자릿 수가 같지 않을 때까지 변경하는지 확인")
    @Test
    void testCheckDigits() {
        int hundred = 1;
        int ten = 1;
        int one = 1;

        ten = random.checkDigits(hundred, one, ten);
        one = random.checkDigits(hundred, ten, one);

        assertThat(hundred).isNotEqualTo(ten);
        assertThat(ten).isNotEqualTo(one);
        assertThat(one).isNotEqualTo(hundred);
    }

    @DisplayName("makeRandomNumber() : Random 함수의 nextInt()가 1 ~ 9를 생성하는 지 확인")
    @Test
    void testTenNumber() {
        int number = random.makeRandomNumber();

        assertThat(number).isBetween(1, 9);
    }
}
