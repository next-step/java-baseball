package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberPackage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.domain.GameNumber.MAXIMUM_GAME_NUMBER;
import static baseball.domain.GameNumber.MINIMUM_GAME_NUMBER;
import static baseball.validator.InputNumbersValidator.GAME_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class RandomGameNumberPackageGeneratorTest {
    private static RandomGameNumberPackageGenerator randomGenerator;

    @BeforeAll
    static void beforeAll() {
        randomGenerator = new RandomGameNumberPackageGenerator();
    }

    @Test
    @DisplayName("generate() 테스트")
    void generate() {
        GameNumberPackage gameNumberPackage = randomGenerator.generate();

        assertThat(gameNumberPackage.size()).isEqualTo(GAME_NUMBER_COUNT);

        for (GameNumber curNumber : gameNumberPackage.getNumbers()) {
            assertThat(gameNumberPackage.containsGameNumber(curNumber)).isTrue();
            assertThat(curNumber.getNumber()).isBetween(MINIMUM_GAME_NUMBER, MAXIMUM_GAME_NUMBER);
        }
    }

}