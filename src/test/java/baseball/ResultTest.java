package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private Result resultTest = Result.getInstance();

    @BeforeAll
    public void init() {
        resultTest.addBall();
        resultTest.addStrike();
        resultTest.addStrike();
    }

    @Test
    void testResult() {
        assertThat(resultTest.toString()).hasToString("2 스트라이크 1 볼 ");
        assertThat(resultTest.toString()).hasToString("낫싱");

        resultTest.addBall();
        assertThat(resultTest.toString()).hasToString("1 볼 ");

        resultTest.addStrike();
        resultTest.addBall();
        resultTest.addBall();
        assertThat(resultTest.toString()).hasToString("1 스트라이크 2 볼 ");
    }

}
