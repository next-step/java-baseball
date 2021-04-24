import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;
    private String randomBalls;

    @BeforeEach
    public void beforeSet() {
        randomGenerator = new RandomGenerator(BaseballGame.DEFAULT_LEN);
        randomBalls = randomGenerator.generateBalls();
    }

    @Test
    public void isValidatedLength() {
        Assertions.assertEquals(randomBalls.length(), BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isValidatedDigit() {
        for (int i=0; i<randomBalls.length(); i++) {
            int num = randomBalls.charAt(i) - '0';
            Assertions.assertEquals(Pattern.matches("^[1-9]", randomBalls.charAt(i) + ""), true );
        }
    }

    public boolean compareBalls(String s1, String s2) {
        return s1.equals(s2) ? true : false;
    }

    public boolean containBalls(String[] containArr, String findValue, int index) {

        boolean isContained = false;

        for(int i=0;i<index;i++)
            isContained = compareBalls(containArr[i],findValue);

        return isContained;
    }

    @Test
    public void isValidatedRandomlyGenerated() {
        int testCnt = 5;
        String ballsArr [] =new String[testCnt];

        for (int i=0; i<testCnt; i++) {
            ballsArr[i] = randomGenerator.generateBalls();
            Assertions.assertEquals(containBalls(ballsArr, ballsArr[i], i), false);
        }
    }
}
