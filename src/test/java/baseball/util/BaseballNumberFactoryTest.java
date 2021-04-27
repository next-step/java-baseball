package baseball.util;

import baseball.domain.BaseballNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static baseball.domain.BaseballNumbers.*;

@DisplayName("야구번호_생성_테스트")
class BaseballNumberFactoryTest {
    private BaseballNumberFactory baseballNumberFactory;

    @BeforeEach
    void setUp() {
        this.baseballNumberFactory = new BaseballNumberFactory();
    }

    @Test
    @DisplayName("야구번호_수가_세_개인지_테스트")
    void verifyThreeBaseballNumbersGenerated() {
        // When
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();

        // Then
        Assertions.assertEquals(RANDOM_NUMBER_COUNT, baseballNumbers.size());
    }

    @Test
    @DisplayName("야구번호_수의_범위가_1~9인지_테스트")
    void verifyBaseballNumbersBoundary() {
        // When
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();

        // Then
        for (String baseballNumber : baseballNumbers.getValues()) {
            Assertions.assertTrue(Integer.parseInt(baseballNumber) >= MIN_RANDOM_NUMBER);
            Assertions.assertTrue(Integer.parseInt(baseballNumber) <= MAX_RANDOM_NUMBER);
        }
    }

    @Test
    @DisplayName("야구번호가_중복되지_않았는지_테스트")
    void verifyBaseballNumbersNonDuplicate() {
        // When
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();
        Set<String> baseballNumbersSet = new HashSet<>(baseballNumbers.getValues());

        // Then
        Assertions.assertEquals(baseballNumbers.size(), baseballNumbersSet.size());
    }
}
