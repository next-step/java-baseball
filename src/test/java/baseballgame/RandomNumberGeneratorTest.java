package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    RandomNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("1부터 9사이의 3자리 랜덤 숫자 생성")
    public void generate_3digits() {
        RandomNumber randomNumber = generator.generateRandomNumber();

        assertThat(randomNumber.firstNumber).isBetween(1, 9);
        assertThat(randomNumber.secondNumber).isBetween(1, 9);
        assertThat(randomNumber.thirdNumber).isBetween(1, 9);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("1부터 9사이의 3자리 랜덤 숫자는 서로 같지 않음")
    public void generate_distinct_3digits() {
        RandomNumber randomNumber = generator.generateRandomNumber();

        assertThat(randomNumber.firstNumber).isNotEqualTo(randomNumber.secondNumber);
        assertThat(randomNumber.firstNumber).isNotEqualTo(randomNumber.thirdNumber);
        assertThat(randomNumber.secondNumber).isNotEqualTo(randomNumber.thirdNumber);
    }
}