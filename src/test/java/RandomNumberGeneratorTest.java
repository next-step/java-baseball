import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomNumberGenerator 테스트")
class RandomNumberGeneratorTest {

    @DisplayName("3자리 수인지 테스트")
    @RepeatedTest(100)
    void randomNumber_3digits() {
        // when
        RandomNumber randomNumber = RandomNumberGenerator.generate();

        // then
        assertThat(randomNumber.getRandomNumber()).isBetween(111, 999);
    }

    @DisplayName("모든 자리 수가 1부터 9 사이의 수인지 테스트")
    @RepeatedTest(100)
    void randomNumber_every_digit_between_1_9() {
        // given
        RandomNumber randomNumber = RandomNumberGenerator.generate();

        // when
        int number = randomNumber.getRandomNumber();
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int units = number % 10;

        // then
        assertThat(hundreds).isBetween(1, 9);
        assertThat(tens).isBetween(1, 9);
        assertThat(units).isBetween(1, 9);
    }
}