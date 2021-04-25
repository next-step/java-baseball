import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberGeneratorTest {

    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("생성된 숫자는 반드시 3자리 여야 한다")
    void testRandomNumberSize() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        String generateNumber = baseballNumberGenerator.generate();
        assertEquals(3, generateNumber.length());
    }

    @Test
    @DisplayName("생성된 숫자들은 각각 다른 숫자 여야 한다")
    void testRandomNumberDifferentEachOther() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        String generateNumber = baseballNumberGenerator.generate();
        String[] split = generateNumber.split("");
        assertNotEquals(split[0], split[1]);
        assertNotEquals(split[0], split[2]);
        assertNotEquals(split[1], split[2]);
        System.out.println(generateNumber);
    }
}